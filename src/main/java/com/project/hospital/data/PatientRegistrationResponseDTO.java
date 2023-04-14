package com.project.hospital.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PatientRegistrationResponseDTO {
    @NotNull
    @Schema(
            required = true,
            example = "ACCEPTED")
    private UserRegistrationStatus status;

    @Schema(
            required = true,
            example = "James")
    private String firstName;

    public enum UserRegistrationStatus{
        ACCEPTED, FAILED
    }
}
