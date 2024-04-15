package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProductUpdateDTO(
        String name,

        String description,

        double salePrice,

        double costPrice,

        double weight
) {
}
