package com.api.greenway.controllers.dtos;

import com.api.greenway.models.CompanyRepresentative;

import java.time.LocalDateTime;

public record CompanyRepresentativeDetailedDTO(

        Long idCompanyRepresentative,
        String phone,
        String role,

        String name,

        LocalDateTime createdAt,

        UserDetailedDTO user,

        CompanyDetailedDTO company

) {

    public CompanyRepresentativeDetailedDTO(CompanyRepresentative companyRepresentative) {
        this(companyRepresentative.getIdCompanyRepresentative(), companyRepresentative.getPhone(),
                companyRepresentative.getRole(), companyRepresentative.getName(),
                companyRepresentative.getCreatedAt(),
                new UserDetailedDTO(companyRepresentative.getUser()),
                new CompanyDetailedDTO(companyRepresentative.getCompany())
        );
    }

}
