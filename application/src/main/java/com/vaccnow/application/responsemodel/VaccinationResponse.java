package com.vaccnow.application.responsemodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class VaccinationResponse {

    private Long scheduleId;
    private Long vaccineId;
    private String vaccineName;
    private String customerName;
    private String customerEmail;
    private LocalDateTime scheduledDateTime;
    private String paymentMethod;
    private String confirmationStatus;
}
