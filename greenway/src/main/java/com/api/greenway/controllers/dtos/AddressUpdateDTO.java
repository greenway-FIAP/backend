package com.api.greenway.controllers.dtos;

public record AddressUpdateDTO(

        String street,

        String zipCode,

        String number,

        String uf,

        String neighborhood,

        String city

) {
}
