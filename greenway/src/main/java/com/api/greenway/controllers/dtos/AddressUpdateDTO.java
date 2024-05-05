package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressUpdateDTO(

        String street,

        String zipCode,

        String number,

        String uf,

        String neighborhood,

        String city

) {
}
