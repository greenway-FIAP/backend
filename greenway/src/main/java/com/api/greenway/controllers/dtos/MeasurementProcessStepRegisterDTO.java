package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record MeasurementProcessStepRegisterDTO(

        @NotNull
        Double result,

        @NotNull
        Long idMeasurement,

        @NotNull
        Long idProcessStep

) {
}
