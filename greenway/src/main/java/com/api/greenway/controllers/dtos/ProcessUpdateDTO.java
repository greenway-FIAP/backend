package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;

import java.time.LocalDateTime;

public record ProcessUpdateDTO(
        String name,

        String description,

        StatusProcess statusProcess,

        int priority,

        LocalDateTime dateStart,

        LocalDateTime dateEnd,

        String comments
) {
}
