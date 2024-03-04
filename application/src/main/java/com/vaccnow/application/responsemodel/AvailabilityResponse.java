package com.vaccnow.application.responsemodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AvailabilityResponse {
    private Long availabilityId;
    private Long vaccineId;
    private String vaccineName;
    private LocalDate availableDate;
    private LocalTime availableTimeSlot;
}
