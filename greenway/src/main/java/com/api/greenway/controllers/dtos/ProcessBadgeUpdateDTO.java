package com.api.greenway.controllers.dtos;

import java.time.LocalDateTime;

public record ProcessBadgeUpdateDTO(

        String urlBadge,

        LocalDateTime dateExpiration

) {
}
