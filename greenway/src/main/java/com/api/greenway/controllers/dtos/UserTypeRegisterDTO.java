package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserTypeRegisterDTO(
        @NotBlank
        String title
) {
}
