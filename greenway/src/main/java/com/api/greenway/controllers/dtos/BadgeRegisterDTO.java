package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BadgeRegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        StatusProcess statusProcess,

        @NotBlank
        String criteria,

        @NotBlank
        String urlImage,

        @NotNull
        Long idSustainableGoal,

        @NotNull
        Long idBadgeLevel

) {
}
