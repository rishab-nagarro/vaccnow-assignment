package com.vaccnow.application.repository;

import com.vaccnow.application.model.AvailabilityEntity;
import com.vaccnow.application.model.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<AvailabilityEntity,Long> {

    List<AvailabilityEntity> findByBranchId(Long branchId);

    List<AvailabilityEntity> findByIdAndBranchId(Long availabilityID, Long branchId);

    List<AvailabilityEntity> findByBranchIdAndAvailableDate(Long branchId, LocalDate date);
}
