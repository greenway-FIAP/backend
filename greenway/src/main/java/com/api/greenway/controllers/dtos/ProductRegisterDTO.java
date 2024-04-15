package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        double salePrice,

        @NotNull
        double costPrice,

        @NotNull
        double weight,

        @NotNull
        Long idProductType,

        @NotNull
        Long idProcess
) {
}
