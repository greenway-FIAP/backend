package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Address;

public record AddressDetailedDTO(
        Long idAddress,
        String street,

        String zipCode,

        String number,

        String uf,

        String neighborhood,

        String city,

        CompanyDetailedDTO company

) {
    public AddressDetailedDTO(Address address) {
        this(address.getIdAddress(), address.getStreet(),
                address.getZipCode(), address.getNumber(),
                address.getUf(), address.getNeighborhood(), address.getCity(),
                new CompanyDetailedDTO(address.getCompany()));
    }
}
