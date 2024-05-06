package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterDTO(

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotNull
        Long idUserType

) {
}
