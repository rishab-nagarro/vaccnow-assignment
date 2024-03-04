package com.vaccnow.application.responsemodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleVaccineResponse {
    private Long scheduleId;
    private String message;
}
