package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record ProcessStepRegisterDTO(
        @NotNull
        Long idProcess,

        @NotNull
        Long idStep
) {
}
