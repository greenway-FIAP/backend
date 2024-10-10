package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import com.api.greenway.models.Badge;

public record BadgeDetailedDTO(

        Long idBadge,
        String name,
        String description,
        StatusProcess statusProcess,
        String criteria,
        String urlImage,
        SustainableGoalDetailedDTO sustainableGoal,
        BadgeLevelDetailedDTO badgeLevel
) {

    public BadgeDetailedDTO(Badge badge) {
        this(badge.getIdBadge(), badge.getName(), badge.getDescription(), badge.getStatusProcess(), badge.getCriteria(), badge.getUrlImage(),
                new SustainableGoalDetailedDTO(badge.getSustainableGoal()),
                new BadgeLevelDetailedDTO(badge.getBadgeLevel())
        );
    }

}
