package com.project.hospital.controller;

import com.project.hospital.data.PatientRegistrationDTO;
import com.project.hospital.data.VitalsDTO;
import com.project.hospital.persistence.PatientEntity;
import com.project.hospital.persistence.VitalsEntity;
import com.project.hospital.persistence.VitalsEntityJpaRepository;
import com.project.hospital.service.PatientRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/patients/register")
@RequiredArgsConstructor
public class PatientRegistrationController {
    private final ModelMapper modelMapper;

    @Autowired
    private PatientRegistrationService registrationService;

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientEntity registerPatient(@RequestBody @Valid PatientRegistrationDTO patientRegistrationDTO){

        var newPatient = modelMapper.map(patientRegistrationDTO, PatientEntity.class);

        return registrationService.createPatient(newPatient);
    }

    @PostMapping("/vitals")
    public VitalsEntity registerVitals(@RequestBody VitalsDTO vitalsDTO){
        var newVitals = modelMapper.map(vitalsDTO, VitalsEntity.class);

        //get the patient
        var patient = registrationService.getPatientById(vitalsDTO.getPatientId()).get();

        newVitals.setPatientEntity(patient);

        return registrationService.saveVital(newVitals);
    }

    @GetMapping()
    public Optional<PatientEntity> getPaient(){
        int id = 1;
        var patient = registrationService.getPatientById(id);

        return patient;
    }

}
