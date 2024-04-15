package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record CompanyRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        double currentRevenue,

        @NotNull
        int size,

        @CNPJ
        @NotBlank
        String cnpj,

        @NotNull
        Long idSector
) {
}
