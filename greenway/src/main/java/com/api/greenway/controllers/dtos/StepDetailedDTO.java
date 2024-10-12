package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import com.api.greenway.models.Step;

import java.time.LocalDateTime;

public record StepDetailedDTO(

        Long idStep,
        String name,

        String description,

        int estimatedTime,

        StatusProcess statusStep,

        LocalDateTime dateStart,

        LocalDateTime dateEnd

) {

    public StepDetailedDTO(Step step) {
        this(step.getIdStep() ,step.getName(), step.getDescription(), step.getEstimatedTime(), step.getStatusStep(),
                step.getDateStart(), step.getDateEnd());
    }

}
