package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record SectorRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description
) {
}
