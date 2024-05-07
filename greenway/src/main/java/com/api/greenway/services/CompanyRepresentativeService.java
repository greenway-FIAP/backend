package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.*;
import com.api.greenway.repositories.CompanyRepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyRepresentativeService {

    private final CompanyRepresentativeRepository companyRepresentativeRepository;

    private final UserService userService;

    private final CompanyService companyService;

    @Autowired
    public CompanyRepresentativeService(CompanyRepresentativeRepository companyRepresentativeRepository, UserService userService, CompanyService companyService) {
        this.companyRepresentativeRepository = companyRepresentativeRepository;
        this.userService = userService;
        this.companyService = companyService;
    }

    public CompanyRepresentative create(CompanyRepresentativeRegisterDTO companyRepresentativeRegisterDTO) {
        CompanyRepresentative companyRepresentative = new CompanyRepresentative(companyRepresentativeRegisterDTO);

        User user = userService.find(companyRepresentativeRegisterDTO.idUser());

        Company company = companyService.find(companyRepresentativeRegisterDTO.idCompany());

        companyRepresentative.setCompany(company);

        companyRepresentative.setUser(user);

        return companyRepresentativeRepository.save(companyRepresentative);
    }

    public Page<CompanyRepresentativeDetailedDTO> list(Pageable pagination) {
        return companyRepresentativeRepository.findByFinishedAtIsNull(pagination).map(CompanyRepresentativeDetailedDTO::new);
    }

    public CompanyRepresentativeDetailedDTO get(Long id) {
        return new CompanyRepresentativeDetailedDTO(companyRepresentativeRepository.findOneByFinishedAtIsNullAndIdCompanyRepresentative(id));
    }

    public void delete(Long id) {
        CompanyRepresentative companyRepresentative = companyRepresentativeRepository.findOneByFinishedAtIsNullAndIdCompanyRepresentative(id);

        companyRepresentative.disable();

        companyRepresentativeRepository.save(companyRepresentative);
    }

    public CompanyRepresentativeDetailedDTO update(Long id, CompanyRepresentativeUpdateDTO companyRepresentativeUpdateDTO) {
        CompanyRepresentative companyRepresentative = companyRepresentativeRepository.findOneByFinishedAtIsNullAndIdCompanyRepresentative(id);

        companyRepresentative.updateInformation(companyRepresentativeUpdateDTO);

        companyRepresentativeRepository.save(companyRepresentative);

        return new CompanyRepresentativeDetailedDTO(companyRepresentative);
    }

}
