package com.project.hospital.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Entity
@Table(name = "vitals")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class VitalsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patientEntity;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "height")
    private int height;

    @NotNull
    @Column(name = "weight")
    private int weight;

    @NotNull
    @Column(name = "bmi")
    private double bmi;

    @NotNull
    @Column(name = "health")
    @Enumerated(EnumType.STRING)
    private Health health;

    @Nullable
    @Column(name = "on_diet")
    @Enumerated(EnumType.STRING)
    private Diet onDiet;

    @Nullable
    @Column(name = "taking_drugs")
    @Enumerated(EnumType.STRING)
    private Drugs takingDrugs;

    public enum Health{
        GOOD, POOR
    }

    public enum Diet{
        YES, NO
    }

    public enum Drugs{
        YES, NO
    }
}
