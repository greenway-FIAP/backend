package com.api.greenway.controllers.dtos;

public record ResourceUpdateDTO(

        String name,
        double costPerUnity,
        String description,
        String unitMeasurent,
        double availability
) {
}
