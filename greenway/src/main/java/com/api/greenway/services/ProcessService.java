package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Company;
import com.api.greenway.models.Process;
import com.api.greenway.repositories.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    private final ProcessRepository processRepository;

    private final CompanyService companyService;

    @Autowired
    public ProcessService(ProcessRepository processRepository, CompanyService companyService) {
        this.processRepository = processRepository;
        this.companyService = companyService;
    }

    public Process find(Long id) {
        return processRepository.findOneByFinishedAtIsNullAndIdProcess(id);
    }

    public Process create(ProcessRegisterDTO processRegisterDTO) {
        Process process = new Process(processRegisterDTO);

        Company company = companyService.find(processRegisterDTO.idCompany());

        process.setCompany(company);

        return processRepository.save(process);
    }

    public Page<ProcessDetailedDTO> list(Pageable pagination) {
        return processRepository.findByFinishedAtIsNull(pagination).map(ProcessDetailedDTO::new);
    }

    public ProcessDetailedDTO get(Long id) {
        return new ProcessDetailedDTO(processRepository.findOneByFinishedAtIsNullAndIdProcess(id));
    }

    public void delete(Long id) {
        Process process = processRepository.findOneByFinishedAtIsNullAndIdProcess(id);

        process.disable();

        processRepository.save(process);
    }

    public ProcessDetailedDTO update(Long id, ProcessUpdateDTO processUpdateDTO) {
        Process process = processRepository.findOneByFinishedAtIsNullAndIdProcess(id);

        process.updateInformation(processUpdateDTO);

        processRepository.save(process);

        return new ProcessDetailedDTO(process);
    }
}
