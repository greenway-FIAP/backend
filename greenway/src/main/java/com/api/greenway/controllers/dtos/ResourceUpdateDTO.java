package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResourceUpdateDTO(

        String name,
        double costPerUnity,
        String description,
        String unitMeasurent,
        double availability
) {
}
