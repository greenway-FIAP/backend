package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyRepresentativeRegisterDTO(

        @NotBlank
        String phone,

        @NotBlank
        String role,

        @NotBlank
        String name,

        @NotNull
        Long idCompany,

        @NotNull
        Long idUser


) {
}
