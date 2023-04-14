package com.project.hospital.data;

import com.project.hospital.persistence.VitalsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class VitalsDTO {
    private int patientId;

    private LocalDate date;

    private int height;

    private int weight;

    private double bmi;

    private VitalsEntity.Health health;

    private VitalsEntity.Diet onDiet;

    private VitalsEntity.Drugs takingDrugs;
}
