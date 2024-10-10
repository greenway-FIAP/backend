package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;

public record BadgeUpdateDTO(

        String name,

        String description,

        StatusProcess statusProcess,

        String criteria,

        String urlImage
) {
}
