package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Company;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CompanyDetailedDTO(

        Long idCompany,
        @NotBlank
        String name,

        String description,

        double currentRevenue,

        int size,

        String cnpj,

        SectorDetailedDTO sector,

        List<ProcessDetailedDTO> processList

) {
    public CompanyDetailedDTO(Company company) {
        this(company.getIdCompany() ,company.getName(), company.getDescription(), company.getCurrentRevenue(),
                company.getSize(), company.getCnpj(),
                new SectorDetailedDTO(company.getSector()),
                company.getProcessList().stream().map(ProcessDetailedDTO::new).toList());
    }
}
