package com.vaccnow.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "availability")
@Getter
@Setter
@NoArgsConstructor
public class AvailabilityEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "branch_id")
    private Long branchId;
    @Column(name = "vaccine_id")
    private Long vaccineId;
    @Column(name = "available_date")
    private LocalDate availableDate;
    @Column(name ="available_time_slot")
    private LocalTime availableTimeSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", insertable = false, updatable = false)
    private BranchEntity branchEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccine_id", referencedColumnName = "id", insertable = false, updatable = false)
    private VaccineEntity vaccineEntity;

}
