package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ProcessStep;

public record ProcessStepDetailedDTO(

        Long idProcessStep,
        ProcessDetailedDTO process,
        StepDetailedDTO step
) {

    public ProcessStepDetailedDTO(ProcessStep processStep){
        this(
              processStep.getIdProcessStep(),
                new ProcessDetailedDTO(processStep.getProcess()),
                new StepDetailedDTO(processStep.getStep())
        );

    }

}
