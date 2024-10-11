package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ImprovementMeasurement;

public record ImprovementMeasurementDetailedDTO(

        Long idImprovementMeasurement,

        SustainableImprovementActionsDetailedDTO sustainableImprovementActions

) {

    public ImprovementMeasurementDetailedDTO (ImprovementMeasurement improvementMeasurement){
        this(
             improvementMeasurement.getIdImprovementMeasurement(),
             new SustainableImprovementActionsDetailedDTO(improvementMeasurement.getSustainableImprovementActions())
        );
    }

}
