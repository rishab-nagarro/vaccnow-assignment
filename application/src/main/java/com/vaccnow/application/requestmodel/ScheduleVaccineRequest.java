package com.vaccnow.application.requestmodel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class ScheduleVaccineRequest {
    @NotNull(message = "Vaccine Id can't be Null")
    private Long vaccineId;
    @NotEmpty(message = "Customer Name can't be Empty")
    private String customerName;
    @NotEmpty(message = "Customer Email can't be Empty")
    private String customerEmail;
    private LocalDateTime scheduledDateTime;
    @Pattern(regexp = "^(Cash|Credit|Farwy)$",message = "Only Cash, Credit, Farwy payment method allowed")
    private String paymentMethod;
}

