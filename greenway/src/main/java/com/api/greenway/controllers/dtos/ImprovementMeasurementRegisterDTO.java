package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record ImprovementMeasurementRegisterDTO(

        @NotNull
        Long idSustainableImprovementActions

) {
}
