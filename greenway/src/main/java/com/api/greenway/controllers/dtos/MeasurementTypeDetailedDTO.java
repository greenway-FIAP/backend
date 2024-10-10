package com.api.greenway.controllers.dtos;

import com.api.greenway.models.MeasurementType;

public record MeasurementTypeDetailedDTO(
        Long idMeasurementType,
        String name,
        String description
) {
    public MeasurementTypeDetailedDTO(MeasurementType measurementType) {
        this(measurementType.getIdMeasurementType(), measurementType.getName(), measurementType.getDescription());
    }
}
