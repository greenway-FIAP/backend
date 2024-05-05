package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRegisterDTO(
        @NotBlank
        String street,

        @NotBlank
        String zipCode,

        @NotBlank
        String number,

        @NotBlank
        String uf,

        @NotBlank
        String neighborhood,

        @NotBlank
        String city,

        @NotNull
        Long idCompany
) {
}
