package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SustainableImprovementActionsRegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String instruction,

        @NotNull
        StatusProcess statusProcess,

        @NotNull
        Integer priority,

        @NotNull
        Long idSustainableGoal

) {
}
