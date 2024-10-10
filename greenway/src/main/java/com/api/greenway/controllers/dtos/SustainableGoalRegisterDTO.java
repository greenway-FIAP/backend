package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SustainableGoalRegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        Double target

) {
}
