package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.SustainableGoal;
import com.api.greenway.repositories.SustainableGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SustainableGoalService {

    private final SustainableGoalRepository sustainableGoalRepository;

    @Autowired
    public SustainableGoalService(SustainableGoalRepository sustainableGoalRepository) {
        this.sustainableGoalRepository = sustainableGoalRepository;
    }

    public SustainableGoal find(Long id) {
        return sustainableGoalRepository.findOneByFinishedAtIsNullAndIdSustainableGoal(id);
    }

    public SustainableGoal create(SustainableGoalRegisterDTO sustainableGoalRegisterDTO) {
        return sustainableGoalRepository.save(new SustainableGoal(sustainableGoalRegisterDTO));
    }

    public Page<SustainableGoalDetailedDTO> list(Pageable pagination) {
        return sustainableGoalRepository.findByFinishedAtIsNull(pagination).map(SustainableGoalDetailedDTO::new);
    }

    public SustainableGoalDetailedDTO get(Long id) {
        return new SustainableGoalDetailedDTO(sustainableGoalRepository.findOneByFinishedAtIsNullAndIdSustainableGoal(id));
    }

    public void delete(Long id) {
        SustainableGoal sustainableGoal = sustainableGoalRepository.findOneByFinishedAtIsNullAndIdSustainableGoal(id);

        sustainableGoal.disable();

        sustainableGoalRepository.save(sustainableGoal);
    }

    public SustainableGoalDetailedDTO update(Long id, SustainableGoalUpdateDTO sustainableGoalUpdateDTO) {
        SustainableGoal sustainableGoal = sustainableGoalRepository.findOneByFinishedAtIsNullAndIdSustainableGoal(id);

        sustainableGoal.updateInformation(sustainableGoalUpdateDTO);

        sustainableGoalRepository.save(sustainableGoal);

        return new SustainableGoalDetailedDTO(sustainableGoal);
    }

}
