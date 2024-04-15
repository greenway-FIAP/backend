package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Company;
import com.api.greenway.models.Process;
import com.api.greenway.models.Sector;
import com.api.greenway.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    private final SectorService sectorService;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, SectorService sectorService) {
        this.companyRepository = companyRepository;
        this.sectorService = sectorService;
    }

    public Company find(Long id) {
        return companyRepository.findOneByFinishedAtIsNullAndIdCompany(id);
    }

    public Company create(CompanyRegisterDTO companyRegisterDTO) {
        Company company = new Company(companyRegisterDTO);

        Sector sector = sectorService.find(companyRegisterDTO.idSector());

        company.setSector(sector);

        return companyRepository.save(company);
    }

    public Page<CompanyDetailedDTO> list(Pageable pagination) {
        return companyRepository.findByFinishedAtIsNull(pagination).map(CompanyDetailedDTO::new);
    }

    public CompanyDetailedDTO get(Long id) {
        return new CompanyDetailedDTO(companyRepository.findOneByFinishedAtIsNullAndIdCompany(id));
    }

    public void delete(Long id) {
        Company company = companyRepository.findOneByFinishedAtIsNullAndIdCompany(id);

        company.disable();

        companyRepository.save(company);
    }

    public CompanyDetailedDTO update(Long id, CompanyUpdateDTO companyUpdateDTO) {
        Company company = companyRepository.findOneByFinishedAtIsNullAndIdCompany(id);

        company.updateInformation(companyUpdateDTO);

        companyRepository.save(company);

        return new CompanyDetailedDTO(company);
    }
}
