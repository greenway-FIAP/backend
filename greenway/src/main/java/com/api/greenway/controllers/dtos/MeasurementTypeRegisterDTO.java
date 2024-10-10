package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record MeasurementTypeRegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String description

) {
}
