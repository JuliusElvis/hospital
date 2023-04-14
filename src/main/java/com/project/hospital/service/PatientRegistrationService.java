package com.project.hospital.service;

import com.project.hospital.persistence.PatientEntity;
import com.project.hospital.persistence.PatientEntityJpaRepository;
import com.project.hospital.persistence.VitalsEntity;
import com.project.hospital.persistence.VitalsEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientRegistrationService{
    @Autowired
    PatientEntityJpaRepository patientRepository;

    @Autowired
    VitalsEntityJpaRepository vitalsRepository;

    public PatientEntity createPatient(PatientEntity patientEntity){
        return patientRepository.save(patientEntity);
    }

    public Optional<PatientEntity> getPatientById(int id){
        return patientRepository.findById(id);
    }

    public VitalsEntity saveVital(VitalsEntity vitalsEntity){
        return vitalsRepository.save(vitalsEntity);
    }
}
