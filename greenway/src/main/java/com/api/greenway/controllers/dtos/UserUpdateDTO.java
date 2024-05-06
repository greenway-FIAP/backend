package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(
        String email,

        String password
) {
}
