package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record ProcessResourceRegisterDTO(
        @NotNull
        Long idResource,

        @NotNull
        Long idProcess
) {
}
