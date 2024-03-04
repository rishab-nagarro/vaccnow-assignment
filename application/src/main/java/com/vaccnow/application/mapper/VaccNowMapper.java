package com.vaccnow.application.mapper;

import com.vaccnow.application.model.AvailabilityEntity;
import com.vaccnow.application.model.BranchEntity;
import com.vaccnow.application.model.ScheduleVaccinationEntity;
import com.vaccnow.application.requestmodel.ScheduleVaccineRequest;
import com.vaccnow.application.responsemodel.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccNowMapper {
    @Mapping(source = "id", target = "branchId")
    BranchResponse entityToResponse(BranchEntity branchEntity);

    @Mapping(source = "id", target = "branchId")
    List<BranchResponse> branchEntityToResponse(List<BranchEntity> branchEntity);


    @Mapping(source = "vaccineEntity.vaccineName", target = "vaccineName")
    @Mapping(source = "vaccineEntity.manufacturer", target = "manufacturer")
    @Mapping(source = "vaccineEntity.type", target = "type")
    @Mapping(source = "vaccineEntity.description", target = "description")
    AvailableVaccineResponse availabilityEntityToAvailableVaccineResponse(AvailabilityEntity availabilityEntity);

    @Mapping(source = "id", target = "availabilityId")
    @Mapping(source = "availableTimeSlot", target = "availableTimeSlot")
    @Mapping(source = "vaccineEntity.vaccineName", target = "vaccineName")
    AvailabilityResponse availabilityEntityToAvailabilityResponse(AvailabilityEntity a);

    @Mapping(source = "id", target = "scheduleId")
    @Mapping(source = "vaccineEntity.vaccineName", target = "vaccineName")
    VaccinationResponse scheduleVaccinationEntityToVaccinationResponse(ScheduleVaccinationEntity s);

    ScheduleVaccinationEntity scheduleVaccineRequestToScheduleVaccinationEntity(ScheduleVaccineRequest scheduleVaccineRequest);
}
