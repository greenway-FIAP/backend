package com.api.greenway.services;

import com.api.greenway.controllers.dtos.StepDetailedDTO;
import com.api.greenway.controllers.dtos.StepRegisterDTO;
import com.api.greenway.controllers.dtos.StepUpdateDTO;
import com.api.greenway.models.Step;
import com.api.greenway.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StepService {

    private final StepRepository stepRepository;

    @Autowired
    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public Step find(Long id) {
        return stepRepository.findOneByFinishedAtIsNullAndIdStep(id);
    }

    public Step create(StepRegisterDTO StepRegisterDTO) {
        Step step = new Step(StepRegisterDTO);

        return stepRepository.save(step);
    }

    public Page<StepDetailedDTO> list(Pageable pagination) {
        return stepRepository.findByFinishedAtIsNull(pagination).map(StepDetailedDTO::new);
    }

    public StepDetailedDTO get(Long id) {
        return new StepDetailedDTO(stepRepository.findOneByFinishedAtIsNullAndIdStep(id));
    }

    public void delete(Long id) {
        Step step = stepRepository.findOneByFinishedAtIsNullAndIdStep(id);

        step.disable();

        stepRepository.save(step);
    }

    public StepDetailedDTO update(Long id, StepUpdateDTO StepUpdateDTO) {
        Step step = stepRepository.findOneByFinishedAtIsNullAndIdStep(id);

        step.updateInformation(StepUpdateDTO);

        stepRepository.save(step);

        return new StepDetailedDTO(step);
    }
    
}
