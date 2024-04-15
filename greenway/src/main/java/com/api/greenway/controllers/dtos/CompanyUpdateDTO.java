package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyUpdateDTO(
        String name,

        String description,

        double currentRevenue,

        int size
) {
}
