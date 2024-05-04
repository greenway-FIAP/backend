package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.*;
import com.api.greenway.models.Process;
import com.api.greenway.repositories.ProcessResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProcessResourceService {

    private final ProcessResourceRepository processResourceRepository;

    private final ProcessService processService;

    private final ResourceService resourceService;

    @Autowired
    public ProcessResourceService(ProcessResourceRepository processResourceRepository, ProcessService processService, ResourceService resourceService) {
        this.processResourceRepository = processResourceRepository;
        this.processService = processService;
        this.resourceService = resourceService;
    }

    public ProcessResource create(ProcessResourceRegisterDTO processResourceRegisterDTO) {

        ProcessResource processResource = new ProcessResource(processResourceRegisterDTO);

        Process process = processService.find(processResourceRegisterDTO.idProcess());

        Resource resource = resourceService.find(processResourceRegisterDTO.idResource());

        processResource.setResource(resource);

        processResource.setProcess(process);

        return processResourceRepository.save(processResource);
    }

    public Page<ProcessResourceDetailedDTO> list(Pageable pagination) {
        return processResourceRepository.findByFinishedAtIsNull(pagination).map(ProcessResourceDetailedDTO::new);
    }

    public ProcessResourceDetailedDTO get(Long id) {
        return new ProcessResourceDetailedDTO(processResourceRepository.findOneByFinishedAtIsNullAndIdProcessResource(id));
    }

    public void delete(Long id) {
        ProcessResource processResource = processResourceRepository.findOneByFinishedAtIsNullAndIdProcessResource(id);

        processResource.disable();

        processResourceRepository.save(processResource);
    }

    public ProcessResourceDetailedDTO update(Long id, ProcessResourceUpdateDTO processResourceUpdateDTO) {
        ProcessResource processResource = processResourceRepository.findOneByFinishedAtIsNullAndIdProcessResource(id);

        processResource.updateInformation(processResourceUpdateDTO);

        processResourceRepository.save(processResource);

        return new ProcessResourceDetailedDTO(processResource);
    }

}
