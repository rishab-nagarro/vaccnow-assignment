package com.vaccnow.application.repository;

import com.vaccnow.application.model.ScheduleVaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleVaccinationRepository extends JpaRepository<ScheduleVaccinationEntity,Long> {
    List<ScheduleVaccinationEntity> findByBranchId(Long branchId);
    @Query(value = "SELECT e FROM ScheduleVaccinationEntity e WHERE e.scheduledDateTime BETWEEN :startDate AND :endDate")
    List<ScheduleVaccinationEntity> findDataByRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    @Query(value = "SELECT e FROM ScheduleVaccinationEntity e WHERE e.scheduledDateTime = :date%")
    List<ScheduleVaccinationEntity> findByDate(LocalDateTime date);
}
