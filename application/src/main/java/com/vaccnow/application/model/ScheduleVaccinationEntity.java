package com.vaccnow.application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="schedule")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ScheduleVaccinationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="branch_id")
    private Long branchId;
    @Column(name="vaccine_id")
    private Long vaccineId;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="customer_email")
    private String customerEmail;
    @Column(name="schedule_date_time")
    private LocalDateTime scheduledDateTime;
    @Column(name="payment_method")
    private String paymentMethod;
    @Column(name="confirmation_status")
    private String confirmationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", insertable = false, updatable = false)
    private BranchEntity branchEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccine_id", referencedColumnName = "id", insertable = false, updatable = false)
    private VaccineEntity vaccineEntity;
}

