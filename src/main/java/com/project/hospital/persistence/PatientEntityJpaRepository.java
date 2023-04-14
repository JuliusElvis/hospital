package com.project.hospital.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientEntityJpaRepository extends JpaRepository<PatientEntity, Integer> {
}
