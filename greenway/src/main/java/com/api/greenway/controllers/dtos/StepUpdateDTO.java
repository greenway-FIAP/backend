package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;

import java.time.LocalDateTime;

public record StepUpdateDTO(
        String name,

        String description,

        int estimatedTime,

        StatusProcess statusStep,

        LocalDateTime dateStart,

        LocalDateTime dateEnd
) {

}
