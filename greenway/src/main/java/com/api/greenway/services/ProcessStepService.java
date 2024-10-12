package com.api.greenway.services;

import com.api.greenway.controllers.dtos.ProcessStepDetailedDTO;
import com.api.greenway.controllers.dtos.ProcessStepRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessStepUpdateDTO;
import com.api.greenway.models.Measurement;
import com.api.greenway.models.Process;
import com.api.greenway.models.ProcessStep;
import com.api.greenway.models.Step;
import com.api.greenway.repositories.ProcessStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProcessStepService {

    private final ProcessStepRepository processStepRepository;

    private final ProcessService processService;

    private final StepService stepService;

    @Autowired
    public ProcessStepService(ProcessStepRepository processStepRepository, ProcessService processService, StepService stepService) {
        this.processStepRepository = processStepRepository;
        this.processService = processService;
        this.stepService = stepService;
    }

    public ProcessStep find(Long id) {
        return processStepRepository.findOneByFinishedAtIsNullAndIdProcessStep(id);
    }

    public ProcessStep create(ProcessStepRegisterDTO processStepRegisterDTO) {

        ProcessStep processStep = new ProcessStep(processStepRegisterDTO);

        Process process = processService.find(processStepRegisterDTO.idProcess());

        Step step = stepService.find(processStepRegisterDTO.idStep());

        processStep.setStep(step);

        processStep.setProcess(process);

        return processStepRepository.save(processStep);
    }

    public Page<ProcessStepDetailedDTO> list(Pageable pagination) {
        return processStepRepository.findByFinishedAtIsNull(pagination).map(ProcessStepDetailedDTO::new);
    }

    public ProcessStepDetailedDTO get(Long id) {
        return new ProcessStepDetailedDTO(processStepRepository.findOneByFinishedAtIsNullAndIdProcessStep(id));
    }

    public void delete(Long id) {
        ProcessStep processStep = processStepRepository.findOneByFinishedAtIsNullAndIdProcessStep(id);

        processStep.disable();

        processStepRepository.save(processStep);
    }

    public ProcessStepDetailedDTO update(Long id, ProcessStepUpdateDTO processStepUpdateDTO) {
        ProcessStep processStep = processStepRepository.findOneByFinishedAtIsNullAndIdProcessStep(id);

        processStep.updateInformation(processStepUpdateDTO);

        processStepRepository.save(processStep);

        return new ProcessStepDetailedDTO(processStep);
    }
    
}
