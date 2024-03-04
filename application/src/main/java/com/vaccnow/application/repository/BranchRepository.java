package com.vaccnow.application.repository;

import com.vaccnow.application.model.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<BranchEntity,Long> {
    public List<BranchEntity> findAll();
}
