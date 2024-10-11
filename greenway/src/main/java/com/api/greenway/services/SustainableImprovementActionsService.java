package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.SustainableGoal;
import com.api.greenway.models.SustainableImprovementActions;
import com.api.greenway.repositories.SustainableImprovementActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SustainableImprovementActionsService {

    private final SustainableImprovementActionsRepository sustainableImprovementActionsRepository;

    private final SustainableGoalService sustainableGoalService;

    @Autowired
    public SustainableImprovementActionsService(SustainableImprovementActionsRepository sustainableImprovementActionsRepository, SustainableGoalService sustainableGoalService) {
        this.sustainableImprovementActionsRepository = sustainableImprovementActionsRepository;
        this.sustainableGoalService = sustainableGoalService;
    }

    public SustainableImprovementActions find(Long id) {
        return sustainableImprovementActionsRepository.findOneByFinishedAtIsNullAndIdSustainableImprovementActions(id);
    }

    public SustainableImprovementActions create(SustainableImprovementActionsRegisterDTO sustainableImprovementActionsRegisterDTO) {
        SustainableImprovementActions sustainableImprovementActions = new SustainableImprovementActions(sustainableImprovementActionsRegisterDTO);

        SustainableGoal sustainableGoal = sustainableGoalService.find(sustainableImprovementActionsRegisterDTO.idSustainableGoal());

        sustainableImprovementActions.setSustainableGoal(sustainableGoal);

        return sustainableImprovementActionsRepository.save(sustainableImprovementActions);
    }

    public Page<SustainableImprovementActionsDetailedDTO> list(Pageable pagination) {
        return sustainableImprovementActionsRepository.findByFinishedAtIsNull(pagination).map(SustainableImprovementActionsDetailedDTO::new);
    }

    public SustainableImprovementActionsDetailedDTO get(Long id) {
        return new SustainableImprovementActionsDetailedDTO(sustainableImprovementActionsRepository.findOneByFinishedAtIsNullAndIdSustainableImprovementActions(id));
    }

    public void delete(Long id) {
        SustainableImprovementActions sustainableImprovementActions = sustainableImprovementActionsRepository.findOneByFinishedAtIsNullAndIdSustainableImprovementActions(id);

        sustainableImprovementActions.disable();

        sustainableImprovementActionsRepository.save(sustainableImprovementActions);
    }

    public SustainableImprovementActionsDetailedDTO update(Long id, SustainableImprovementActionsUpdateDTO sustainableImprovementActionsUpdateDTO) {
        SustainableImprovementActions sustainableImprovementActions = sustainableImprovementActionsRepository.findOneByFinishedAtIsNullAndIdSustainableImprovementActions(id);

        sustainableImprovementActions.updateInformation(sustainableImprovementActionsUpdateDTO);

        sustainableImprovementActionsRepository.save(sustainableImprovementActions);

        return new SustainableImprovementActionsDetailedDTO(sustainableImprovementActions);
    }

}
