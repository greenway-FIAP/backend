package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Measurement;

public record MeasurementDetailedDTO(
        Long idMeasurement,
        String name,
        String description,
        MeasurementTypeDetailedDTO measurementType,
        SustainableGoalDetailedDTO sustainableGoal
) {

    public MeasurementDetailedDTO(Measurement measurement) {
        this(
                measurement.getIdMeasurement(),
                measurement.getName(),
                measurement.getDescription(),
                measurement.getMeasurementType() != null ? new MeasurementTypeDetailedDTO(measurement.getMeasurementType()) : null,
                measurement.getSustainableGoal() != null ? new SustainableGoalDetailedDTO(measurement.getSustainableGoal()) : null
        );
    }
}