package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;

public record CompanyRepresentativeUpdateDTO(

        String phone,

        String role,

        String name

) {
}
