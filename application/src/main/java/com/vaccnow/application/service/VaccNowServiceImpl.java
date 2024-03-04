package com.vaccnow.application.service;

import com.vaccnow.application.mapper.VaccNowMapper;
import com.vaccnow.application.model.AvailabilityEntity;
import com.vaccnow.application.model.BranchEntity;
import com.vaccnow.application.model.ScheduleVaccinationEntity;
import com.vaccnow.application.repository.AvailabilityRepository;
import com.vaccnow.application.repository.BranchRepository;
import com.vaccnow.application.repository.ScheduleVaccinationRepository;
import com.vaccnow.application.repository.VaccineRepository;
import com.vaccnow.application.requestmodel.EmailDetailModel;
import com.vaccnow.application.requestmodel.ScheduleVaccineRequest;
import com.vaccnow.application.responsemodel.*;
import com.vaccnow.application.util.AppConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class VaccNowServiceImpl implements VaccNowService {

    private final VaccNowMapper vaccNowMapper;
    private final EmailService emailService;
    private final AvailabilityRepository availabilityRepository;
    private final BranchRepository branchRepository;
    private final ScheduleVaccinationRepository scheduleVaccinationRepository;
    private static final Logger logger = LoggerFactory.getLogger(VaccNowServiceImpl.class);
    @Override
    public List<BranchResponse> getAllBranches() throws Exception {
        try {
            logger.info("Inside getAllBranches");
            List<BranchEntity> branchList = branchRepository.findAll();
            if (!branchList.isEmpty()) {
                return vaccNowMapper.branchEntityToResponse(branchList);
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getAllBranches method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<AvailableVaccineResponse> getAvailableVaccines(Long branchId) throws Exception {
        try {
            logger.info("*** Inside getAvailableVaccines ***");
            List<AvailabilityEntity> availabilityEntityList = availabilityRepository.findByBranchId(branchId);
            List<AvailableVaccineResponse> availableVaccineResponseList = new ArrayList<>();
            if (!availabilityEntityList.isEmpty()) {
                for (AvailabilityEntity a : availabilityEntityList) {
                    availableVaccineResponseList.add(vaccNowMapper.availabilityEntityToAvailableVaccineResponse(a));
                }
                return availableVaccineResponseList;
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getAvailableVaccines method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<AvailabilityResponse> getSpecificAvailabilityByBranch(Long branchId) throws Exception {
        try {
            logger.info("*** Inside getSpecificAvailabilityByBranch ***");
            List<AvailabilityEntity> availabilityEntityList = availabilityRepository.findByBranchId(branchId);
            List<AvailabilityResponse> availabilityResponseList = new ArrayList<>();
            if (!availabilityEntityList.isEmpty()) {
                for (AvailabilityEntity a : availabilityEntityList) {
                    availabilityResponseList.add(vaccNowMapper.availabilityEntityToAvailabilityResponse(a));
                }
                return availabilityResponseList;
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getSpecificAvailabilityByBranch method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public TimeSlots getAvailableTimeSlots(Long branchId, LocalDate date) throws Exception {
        try {
            logger.info("*** Inside getAvailableTimeSlots  ***");
            List<AvailabilityEntity> availability = availabilityRepository.findByBranchIdAndAvailableDate(branchId, date);
            TimeSlots timeSlots = new TimeSlots();
            if (availability != null) {
                List<LocalTime> localTimeList = new ArrayList<>();
                for (AvailabilityEntity a : availability) {
                    localTimeList.add(a.getAvailableTimeSlot());
                }
                timeSlots.setTimeSlots(localTimeList);
                return timeSlots;
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getAvailableTimeSlots method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public ScheduleVaccineResponse scheduleVaccine(Long branchId, ScheduleVaccineRequest scheduleVaccineRequest) throws Exception {
        try {
            logger.info("*** Inside scheduleVaccine  ***");
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime futureDatetime = currentDateTime.plusMinutes(15);
            List<AvailabilityEntity> availabilityEntityList = availabilityRepository.findByBranchId(branchId);
            if (!availabilityEntityList.isEmpty()) {
                if (scheduleVaccineRequest.getScheduledDateTime().isAfter(futureDatetime)) {
                    LocalDate date = scheduleVaccineRequest.getScheduledDateTime().toLocalDate();
                    LocalTime time = scheduleVaccineRequest.getScheduledDateTime().toLocalTime();
                    if (availabilityEntityList.stream().filter(e -> date.equals(e.getAvailableDate())
                            && time.equals(e.getAvailableTimeSlot())
                            && scheduleVaccineRequest.getVaccineId().equals(e.getVaccineId())).findFirst().isPresent()) {
                        ScheduleVaccinationEntity entity = new ScheduleVaccinationEntity();
                        entity.setVaccineId(scheduleVaccineRequest.getVaccineId());
                        entity.setBranchId(branchId);
                        entity.setCustomerName(scheduleVaccineRequest.getCustomerName());
                        entity.setCustomerEmail(scheduleVaccineRequest.getCustomerEmail());
                        entity.setPaymentMethod(scheduleVaccineRequest.getPaymentMethod());
                        entity.setScheduledDateTime(scheduleVaccineRequest.getScheduledDateTime());
                        entity.setConfirmationStatus(AppConstant.CONFIRMED);
                        entity = scheduleVaccinationRepository.save(entity);

                        EmailDetailModel emailDetailModel = new EmailDetailModel();
                        emailDetailModel.setPersonEmailId(scheduleVaccineRequest.getCustomerEmail());
                        String subject = AppConstant.VACCINATION_SUBJECT;
                        String message = "Hi" + scheduleVaccineRequest.getCustomerName() + "\n\n" + AppConstant.SUCCESS_MESSAGE;
                        emailDetailModel.setSubject(subject);
                        emailDetailModel.setMessage(message);
                        logger.info("*** Before Mail sent. ***");
                        emailService.SendCustomEmail(emailDetailModel);
                        logger.info("*** After Mail sent. ***");
                        ScheduleVaccineResponse scheduleVaccineResponse = new ScheduleVaccineResponse();
                        scheduleVaccineResponse.setScheduleId(entity.getId());
                        scheduleVaccineResponse.setMessage(AppConstant.SUCCESS_MESSAGE);
                        return scheduleVaccineResponse;
                    } else {
                        throw new IllegalArgumentException(AppConstant.NO_SLOT_ERROR_MESSAGE);
                    }
                } else {
                    throw new IllegalArgumentException(AppConstant.TIME_GAP_ERROR_MESSAGE);
                }
            } else {
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in scheduleVaccine method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<VaccinationResponse> getAllAppliedVaccinationPerBranch(Long branchId) throws Exception {
        try {
            logger.info("*** Inside getAllAppliedVaccinationPerBranch  ***");
            List<ScheduleVaccinationEntity> scheduleVaccinationList = scheduleVaccinationRepository.findByBranchId(branchId);
            List<VaccinationResponse> vaccinationResponseList = new ArrayList<>();
            if (!scheduleVaccinationList.isEmpty()) {
                for (ScheduleVaccinationEntity s : scheduleVaccinationList) {
                    vaccinationResponseList.add(vaccNowMapper.scheduleVaccinationEntityToVaccinationResponse(s));
                }
                return vaccinationResponseList;
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getAllAppliedVaccinationPerBranch method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<VaccinationResponse> getAllAppliedVaccinationPerDay(LocalDate date) throws Exception {
        try {
            logger.info("*** Inside getAllAppliedVaccinationPerDay  ***");
            LocalDateTime startDateTime = date.atStartOfDay();
            LocalDateTime endDateTime = date.atTime(LocalTime.MAX);
            List<ScheduleVaccinationEntity> scheduleVaccinationList = scheduleVaccinationRepository.findDataByRange(startDateTime, endDateTime);;
            List<VaccinationResponse> vaccinationResponseList = new ArrayList<>();
            if (!scheduleVaccinationList.isEmpty()) {
                for (ScheduleVaccinationEntity s : scheduleVaccinationList) {
                    vaccinationResponseList.add(vaccNowMapper.scheduleVaccinationEntityToVaccinationResponse(s));
                }
                return vaccinationResponseList;
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getAllAppliedVaccinationPerDay method ****");
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<VaccinationResponse> getAllConfirmedVaccination(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        try {
            logger.info("*** Inside getAllConfirmedVaccination  ***");
            List<ScheduleVaccinationEntity> scheduleVaccinationList = scheduleVaccinationRepository.findDataByRange(startDate, endDate);
            List<VaccinationResponse> vaccinationResponseList = new ArrayList<>();
            if (!scheduleVaccinationList.isEmpty()) {
                for (ScheduleVaccinationEntity s : scheduleVaccinationList) {
                    vaccinationResponseList.add(vaccNowMapper.scheduleVaccinationEntityToVaccinationResponse(s));
                }
                return vaccinationResponseList;
            } else {
                logger.error(AppConstant.NO_DATA_AVAILABLE);
                throw new DataRetrievalFailureException(AppConstant.NO_DATA_AVAILABLE);
            }
        } catch (Exception ex) {
            logger.error("**** Error Occur in getAllConfirmedVaccination method ****");
            throw new Exception(ex.getMessage());
        }
    }
}
