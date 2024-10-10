package com.api.greenway.controllers.dtos;

public record SustainableGoalUpdateDTO(

        String name,
        String description,
        Double target

) {
}
