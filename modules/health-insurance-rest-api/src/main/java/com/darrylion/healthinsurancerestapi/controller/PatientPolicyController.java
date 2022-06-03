package com.darrylion.healthinsurancerestapi.controller;


import com.darrylion.healthinsurancerestapi.entity.PatientPolicy;
import com.darrylion.healthinsurancerestapi.repository.PatientPolicyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("patient_policies")
@RequiredArgsConstructor
public class PatientPolicyController {

    private final PatientPolicyRepository repository;

    @Operation(summary = "Get patient policies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policies of patients found",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PatientPolicy.class)))})})
    @GetMapping("/")
    public List<PatientPolicy> getPatientPolicies() {
        return repository.findAll();
    }

    @Operation(summary = "Get the patient's policy by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient policy found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientPolicy.class))})})
    @GetMapping("/{id}")
    public PatientPolicy getPatientPolicy(@PathVariable long id) {
        return repository.findById(id).orElseThrow();
    }

    @Operation(summary = "Add a new patient policy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New patient policy added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientPolicy.class))})})
    @PostMapping("/")
    public PatientPolicy savePatientPolicy(@ModelAttribute PatientPolicy patientPolicy) {
        return repository.save(patientPolicy);
    }

    @Operation(summary = "Update patient by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient policy updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientPolicy.class))})})
    @PutMapping("/{id}")
    public PatientPolicy replacePatientPolicy(@ModelAttribute PatientPolicy newPatientPolicy, @PathVariable Long id) {
        return repository.findById(id)
                .map(patientPolicy -> {
                    patientPolicy.setLastName(newPatientPolicy.getLastName());
                    patientPolicy.setFirstName(newPatientPolicy.getFirstName());
                    patientPolicy.setPatronymic(newPatientPolicy.getPatronymic());
                    patientPolicy.setBirthday(newPatientPolicy.getBirthday());
                    patientPolicy.setTermPolicy(newPatientPolicy.getTermPolicy());
                    return repository.save(patientPolicy);
                })
                .orElseGet(() -> repository.save(newPatientPolicy));
    }

    @Operation(summary = "Delete patient policy by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient policy removed")})
    @DeleteMapping("/{id}")
    public void deletePatientPolicy(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
