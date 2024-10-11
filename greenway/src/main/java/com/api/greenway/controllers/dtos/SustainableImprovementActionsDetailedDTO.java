package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import com.api.greenway.models.SustainableImprovementActions;

public record SustainableImprovementActionsDetailedDTO(

        Long idSustainableImprovementActions,
        String name,
        String instruction,
        StatusProcess statusProcess,
        Integer priority,
        SustainableGoalDetailedDTO sustainableGoal

) {

    public SustainableImprovementActionsDetailedDTO (SustainableImprovementActions sustainableImprovementActions){
        this(sustainableImprovementActions.getIdSustainableImprovementActions(), sustainableImprovementActions.getName(), sustainableImprovementActions.getInstruction()
        , sustainableImprovementActions.getStatusProcess(), sustainableImprovementActions.getPriority(),
                new SustainableGoalDetailedDTO(sustainableImprovementActions.getSustainableGoal()));
    }

}
