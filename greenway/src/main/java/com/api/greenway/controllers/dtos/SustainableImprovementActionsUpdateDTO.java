package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;

public record SustainableImprovementActionsUpdateDTO(

        String name,
        String instruction,
        StatusProcess statusProcess,
        Integer priority

) {
}
