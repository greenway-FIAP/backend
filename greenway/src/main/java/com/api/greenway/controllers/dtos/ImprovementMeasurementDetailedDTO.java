package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ImprovementMeasurement;

public record ImprovementMeasurementDetailedDTO(

        Long idImprovementMeasurement,

        SustainableImprovementActionsDetailedDTO sustainableImprovementActions,

        MeasurementDetailedDTO measurement

) {

    public ImprovementMeasurementDetailedDTO (ImprovementMeasurement improvementMeasurement){
        this(
             improvementMeasurement.getIdImprovementMeasurement(),
             new SustainableImprovementActionsDetailedDTO(improvementMeasurement.getSustainableImprovementActions()),
                new MeasurementDetailedDTO(improvementMeasurement.getMeasurement())
        );
    }

}
