package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
