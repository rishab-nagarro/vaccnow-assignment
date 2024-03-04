package com.vaccnow.application.controller;

import com.vaccnow.application.requestmodel.ScheduleVaccineRequest;
import com.vaccnow.application.responsemodel.*;
import com.vaccnow.application.service.VaccNowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VaccNowController {

    private final VaccNowService vaccNowService;
    @GetMapping(value = "/branches",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BranchResponse>> getAllBranches() throws Exception {
        List<BranchResponse> branches =  vaccNowService.getAllBranches();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @GetMapping(value = "/branches/{branchId}/vaccines",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<AvailableVaccineResponse>> getAvailableVaccines(@PathVariable  Long branchId) throws Exception {
        List<AvailableVaccineResponse> vaccines =  vaccNowService.getAvailableVaccines(branchId);
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @GetMapping(value = "/branches/{branchId}/availability",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AvailabilityResponse>> getAvailabilityByBranch(@PathVariable  Long branchId) throws Exception {
        List<AvailabilityResponse> availability  =  vaccNowService.getSpecificAvailabilityByBranch(branchId);
        return new ResponseEntity<>(availability, HttpStatus.OK);
    }

    @GetMapping(value = "/branches/{branchId}/availability/{date}/timeslots",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeSlots> getAvailableTimeSlots(@PathVariable Long branchId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception {
        TimeSlots timeSlots =  vaccNowService.getAvailableTimeSlots(branchId, date);
        return new ResponseEntity<>(timeSlots, HttpStatus.OK);
    }

    @PostMapping(value = "/branches/{branchId}/vaccinate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ScheduleVaccineResponse> scheduleVaccine(@PathVariable Long branchId, @RequestBody @Valid ScheduleVaccineRequest scheduleVaccineRequest) throws Exception {
        ScheduleVaccineResponse scheduleVaccine =  vaccNowService.scheduleVaccine(branchId,scheduleVaccineRequest);
        return new ResponseEntity<>(scheduleVaccine, HttpStatus.OK);
    }

    @GetMapping(value = "/branches/{branchId}/vaccinations",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VaccinationResponse>> getAllAppliedVaccinationPerBranch(@PathVariable Long branchId) throws Exception {
        List<VaccinationResponse> response =  vaccNowService.getAllAppliedVaccinationPerBranch(branchId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/vaccinations/day",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VaccinationResponse>> getAllAppliedVaccinationPerDay(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception {
        List<VaccinationResponse> response =  vaccNowService.getAllAppliedVaccinationPerDay(date);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/vaccinations",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VaccinationResponse>> getAllConfirmedVaccination(@RequestParam  LocalDateTime startDate, @RequestParam  LocalDateTime endDate) throws Exception {
        List<VaccinationResponse> response =  vaccNowService.getAllConfirmedVaccination(startDate,endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
