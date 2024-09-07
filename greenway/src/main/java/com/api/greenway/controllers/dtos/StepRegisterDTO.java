package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record StepRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        int estimatedTime,

        @NotNull
        StatusProcess statusStep,

        @NotNull
        LocalDateTime dateStart,

        @NotNull
        LocalDateTime dateEnd
) {

}
