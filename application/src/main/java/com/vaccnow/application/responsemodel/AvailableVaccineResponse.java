package com.vaccnow.application.responsemodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AvailableVaccineResponse {
    private Long vaccineId;
    private String vaccineName;
    private String manufacturer;
    private String type;
    private String description;
}
