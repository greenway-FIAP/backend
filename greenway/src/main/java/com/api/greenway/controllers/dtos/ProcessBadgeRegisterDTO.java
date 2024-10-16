package com.api.greenway.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProcessBadgeRegisterDTO(

        @NotBlank
        String urlBadge,

        @NotNull
        LocalDateTime dateExpiration,

         @NotNull
         Long idProcess,

         @NotNull
         Long idBadge

) {
}
