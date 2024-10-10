package com.api.greenway.controllers.dtos;

import com.api.greenway.models.SustainableGoal;

public record SustainableGoalDetailedDTO(

        Long idSustainableGoal,
        String name,
        String description,
        Double target

) {

    public SustainableGoalDetailedDTO(SustainableGoal sustainableGoal) {
        this(sustainableGoal.getIdSustainableGoal() ,sustainableGoal.getName(), sustainableGoal.getDescription(), sustainableGoal.getTarget());
    }

}
