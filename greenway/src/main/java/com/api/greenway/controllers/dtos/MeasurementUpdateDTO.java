package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record MeasurementUpdateDTO(

        String name,
        String description

) {
}
