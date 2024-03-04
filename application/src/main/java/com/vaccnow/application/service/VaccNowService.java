package com.vaccnow.application.service;

import com.vaccnow.application.requestmodel.ScheduleVaccineRequest;
import com.vaccnow.application.responsemodel.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface VaccNowService {
    List<BranchResponse> getAllBranches() throws Exception;

    List<AvailableVaccineResponse> getAvailableVaccines(Long branchId) throws Exception;

    List<AvailabilityResponse> getSpecificAvailabilityByBranch(Long branchId) throws Exception;

    TimeSlots getAvailableTimeSlots(Long branchId, LocalDate date) throws Exception;

    ScheduleVaccineResponse scheduleVaccine(Long branchId, ScheduleVaccineRequest scheduleVaccineRequest) throws Exception;

    List<VaccinationResponse> getAllAppliedVaccinationPerBranch(Long branchId) throws Exception;

    List<VaccinationResponse> getAllAppliedVaccinationPerDay(LocalDate date) throws Exception;

    List<VaccinationResponse> getAllConfirmedVaccination(LocalDateTime startDate, LocalDateTime endDate) throws Exception;
}
