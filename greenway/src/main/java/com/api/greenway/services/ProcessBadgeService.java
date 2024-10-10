package com.api.greenway.services;

import com.api.greenway.controllers.dtos.ProcessBadgeRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessBadgeDetailedDTO;
import com.api.greenway.controllers.dtos.ProcessBadgeUpdateDTO;
import com.api.greenway.models.Process;
import com.api.greenway.models.ProcessBadge;
import com.api.greenway.repositories.ProcessBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProcessBadgeService {

    private final ProcessBadgeRepository processBadgeRepository;

    private final ProcessService processService;

    @Autowired
    public ProcessBadgeService(ProcessBadgeRepository processBadgeRepository, ProcessService processService) {
        this.processBadgeRepository = processBadgeRepository;
        this.processService = processService;
    }

    public ProcessBadge find(Long id) {
        return processBadgeRepository.findOneByFinishedAtIsNullAndIdProcessBadge(id);
    }

    public ProcessBadge create(ProcessBadgeRegisterDTO processBadgeRegisterDTO) {
        ProcessBadge processBadge = new ProcessBadge(processBadgeRegisterDTO);

        Process process = processService.find(processBadgeRegisterDTO.idProcess());

        processBadge.setProcess(process);

        return processBadgeRepository.save(processBadge);
    }

    public Page<ProcessBadgeDetailedDTO> list(Pageable pagination) {
        return processBadgeRepository.findByFinishedAtIsNull(pagination).map(ProcessBadgeDetailedDTO::new);
    }


    public ProcessBadgeDetailedDTO get(Long id) {
        return new ProcessBadgeDetailedDTO(processBadgeRepository.findOneByFinishedAtIsNullAndIdProcessBadge(id));
    }

    public void delete(Long id) {
        ProcessBadge process = processBadgeRepository.findOneByFinishedAtIsNullAndIdProcessBadge(id);

        process.disable();

        processBadgeRepository.save(process);
    }

    public ProcessBadgeDetailedDTO update(Long id, ProcessBadgeUpdateDTO processBadgeUpdateDTO) {
        ProcessBadge processBadge = processBadgeRepository.findOneByFinishedAtIsNullAndIdProcessBadge(id);

        processBadge.updateInformation(processBadgeUpdateDTO);

        processBadgeRepository.save(processBadge);

        return new ProcessBadgeDetailedDTO(processBadge);
    }

}
