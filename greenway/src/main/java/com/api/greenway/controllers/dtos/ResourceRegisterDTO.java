package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResourceRegisterDTO (

        @NotBlank
        String name,
        @NotNull
        double costPerUnity,
        @NotBlank
        String description,

        @NotBlank
        String unitMeasurent,

        @NotNull
        double availability,

        @NotNull
        Long idResourceType
){
}
