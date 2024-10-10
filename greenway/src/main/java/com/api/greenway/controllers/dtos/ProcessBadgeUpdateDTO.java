package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;

import java.time.LocalDateTime;

public record ProcessBadgeUpdateDTO(

        String urlBadge,

        LocalDateTime dateExpiration

) {
}
