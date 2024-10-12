package com.api.greenway.controllers.dtos;

import com.api.greenway.models.MeasurementProcessStep;

public record MeasurementProcessStepDetailedDTO(

        Long idMeasurementProcessStep,

        Double result,

        ProcessStepDetailedDTO processStep,

        MeasurementDetailedDTO measurement

) {

    public MeasurementProcessStepDetailedDTO (MeasurementProcessStep measurementProcessStep) {

        this(
                measurementProcessStep.getIdMeasurementProcessStep(), measurementProcessStep.getResult(),
                new ProcessStepDetailedDTO(measurementProcessStep.getProcessStep()),
                new MeasurementDetailedDTO(measurementProcessStep.getMeasurement())
        );

    }

}
