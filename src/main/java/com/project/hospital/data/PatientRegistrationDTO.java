package com.project.hospital.data;

import com.project.hospital.persistence.PatientEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
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
public class PatientRegistrationDTO {

    @NotNull
    @Schema(
            required = true,
            example = "john")
    private String firstName;

    @NotNull
    @Schema(
            required = true,
            example = "doe")
    private String lastName;

    @Schema(
            required = true,
            example = "2022-10-11"
    )
    @NotNull
    private LocalDate dob;

    private PatientEntity.Gender gender;
}
