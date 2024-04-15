package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProcessRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        StatusProcess statusProcess,

        @NotNull
        int priority,

        @NotNull
        LocalDateTime dateStart,

        @NotNull
        LocalDateTime dateEnd,

        String comments,

        @NotNull
        Long idCompany
) {
}
