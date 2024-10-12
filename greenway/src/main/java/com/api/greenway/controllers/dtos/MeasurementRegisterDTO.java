package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MeasurementRegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        Long idMeasurementType,

        @NotNull
        Long idSustainableGoal

) {
}
