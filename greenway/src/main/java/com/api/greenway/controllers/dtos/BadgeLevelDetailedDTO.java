package com.api.greenway.controllers.dtos;

import com.api.greenway.models.BadgeLevel;

public record BadgeLevelDetailedDTO(

        Long idBadgeLevel,
        String name,
        String description

) {

    public BadgeLevelDetailedDTO(BadgeLevel badgeLevel) {
        this(badgeLevel.getIdBadgeLevel() ,badgeLevel.getName(), badgeLevel.getDescription());
    }

}