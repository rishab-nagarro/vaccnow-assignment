package com.vaccnow.application.mapper;

import com.vaccnow.application.model.AvailabilityEntity;
import com.vaccnow.application.model.BranchEntity;
import com.vaccnow.application.model.ScheduleVaccinationEntity;
import com.vaccnow.application.model.VaccineEntity;
import com.vaccnow.application.requestmodel.ScheduleVaccineRequest;
import com.vaccnow.application.responsemodel.AvailabilityResponse;
import com.vaccnow.application.responsemodel.AvailableVaccineResponse;
import com.vaccnow.application.responsemodel.BranchResponse;
import com.vaccnow.application.responsemodel.VaccinationResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T03:31:14+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class VaccNowMapperImpl implements VaccNowMapper {

    @Override
    public BranchResponse entityToResponse(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }

        BranchResponse branchResponse = new BranchResponse();

        branchResponse.setBranchId( branchEntity.getId() );
        branchResponse.setBranchName( branchEntity.getBranchName() );
        branchResponse.setAddress( branchEntity.getAddress() );
        branchResponse.setContactInfo( branchEntity.getContactInfo() );

        return branchResponse;
    }

    @Override
    public List<BranchResponse> branchEntityToResponse(List<BranchEntity> branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }

        List<BranchResponse> list = new ArrayList<BranchResponse>( branchEntity.size() );
        for ( BranchEntity branchEntity1 : branchEntity ) {
            list.add( entityToResponse( branchEntity1 ) );
        }

        return list;
    }

    @Override
    public AvailableVaccineResponse availabilityEntityToAvailableVaccineResponse(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }

        AvailableVaccineResponse availableVaccineResponse = new AvailableVaccineResponse();

        availableVaccineResponse.setVaccineName( availabilityEntityVaccineEntityVaccineName( availabilityEntity ) );
        availableVaccineResponse.setManufacturer( availabilityEntityVaccineEntityManufacturer( availabilityEntity ) );
        availableVaccineResponse.setType( availabilityEntityVaccineEntityType( availabilityEntity ) );
        availableVaccineResponse.setDescription( availabilityEntityVaccineEntityDescription( availabilityEntity ) );
        availableVaccineResponse.setVaccineId( availabilityEntity.getVaccineId() );

        return availableVaccineResponse;
    }

    @Override
    public AvailabilityResponse availabilityEntityToAvailabilityResponse(AvailabilityEntity a) {
        if ( a == null ) {
            return null;
        }

        AvailabilityResponse availabilityResponse = new AvailabilityResponse();

        availabilityResponse.setAvailabilityId( a.getId() );
        availabilityResponse.setAvailableTimeSlot( a.getAvailableTimeSlot() );
        availabilityResponse.setVaccineName( availabilityEntityVaccineEntityVaccineName( a ) );
        availabilityResponse.setVaccineId( a.getVaccineId() );
        availabilityResponse.setAvailableDate( a.getAvailableDate() );

        return availabilityResponse;
    }

    @Override
    public VaccinationResponse scheduleVaccinationEntityToVaccinationResponse(ScheduleVaccinationEntity s) {
        if ( s == null ) {
            return null;
        }

        VaccinationResponse vaccinationResponse = new VaccinationResponse();

        vaccinationResponse.setScheduleId( s.getId() );
        vaccinationResponse.setVaccineName( sVaccineEntityVaccineName( s ) );
        vaccinationResponse.setVaccineId( s.getVaccineId() );
        vaccinationResponse.setCustomerName( s.getCustomerName() );
        vaccinationResponse.setCustomerEmail( s.getCustomerEmail() );
        vaccinationResponse.setScheduledDateTime( s.getScheduledDateTime() );
        vaccinationResponse.setPaymentMethod( s.getPaymentMethod() );
        vaccinationResponse.setConfirmationStatus( s.getConfirmationStatus() );

        return vaccinationResponse;
    }

    @Override
    public ScheduleVaccinationEntity scheduleVaccineRequestToScheduleVaccinationEntity(ScheduleVaccineRequest scheduleVaccineRequest) {
        if ( scheduleVaccineRequest == null ) {
            return null;
        }

        ScheduleVaccinationEntity scheduleVaccinationEntity = new ScheduleVaccinationEntity();

        scheduleVaccinationEntity.setVaccineId( scheduleVaccineRequest.getVaccineId() );
        scheduleVaccinationEntity.setCustomerName( scheduleVaccineRequest.getCustomerName() );
        scheduleVaccinationEntity.setCustomerEmail( scheduleVaccineRequest.getCustomerEmail() );
        scheduleVaccinationEntity.setScheduledDateTime( scheduleVaccineRequest.getScheduledDateTime() );
        scheduleVaccinationEntity.setPaymentMethod( scheduleVaccineRequest.getPaymentMethod() );

        return scheduleVaccinationEntity;
    }

    private String availabilityEntityVaccineEntityVaccineName(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        VaccineEntity vaccineEntity = availabilityEntity.getVaccineEntity();
        if ( vaccineEntity == null ) {
            return null;
        }
        String vaccineName = vaccineEntity.getVaccineName();
        if ( vaccineName == null ) {
            return null;
        }
        return vaccineName;
    }

    private String availabilityEntityVaccineEntityManufacturer(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        VaccineEntity vaccineEntity = availabilityEntity.getVaccineEntity();
        if ( vaccineEntity == null ) {
            return null;
        }
        String manufacturer = vaccineEntity.getManufacturer();
        if ( manufacturer == null ) {
            return null;
        }
        return manufacturer;
    }

    private String availabilityEntityVaccineEntityType(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        VaccineEntity vaccineEntity = availabilityEntity.getVaccineEntity();
        if ( vaccineEntity == null ) {
            return null;
        }
        String type = vaccineEntity.getType();
        if ( type == null ) {
            return null;
        }
        return type;
    }

    private String availabilityEntityVaccineEntityDescription(AvailabilityEntity availabilityEntity) {
        if ( availabilityEntity == null ) {
            return null;
        }
        VaccineEntity vaccineEntity = availabilityEntity.getVaccineEntity();
        if ( vaccineEntity == null ) {
            return null;
        }
        String description = vaccineEntity.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private String sVaccineEntityVaccineName(ScheduleVaccinationEntity scheduleVaccinationEntity) {
        if ( scheduleVaccinationEntity == null ) {
            return null;
        }
        VaccineEntity vaccineEntity = scheduleVaccinationEntity.getVaccineEntity();
        if ( vaccineEntity == null ) {
            return null;
        }
        String vaccineName = vaccineEntity.getVaccineName();
        if ( vaccineName == null ) {
            return null;
        }
        return vaccineName;
    }
}
