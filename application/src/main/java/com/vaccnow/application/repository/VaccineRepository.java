package com.vaccnow.application.repository;

import com.vaccnow.application.model.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRepository extends JpaRepository<VaccineEntity,Long> {
//    List<VaccineEntity> findByBranchId(Long branchId);
}
