package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ProcessBadge;

import java.time.LocalDateTime;

public record ProcessBadgeDetailedDTO(

        Long idProcessBadge,
        String urlBadge,
        LocalDateTime dateExpiration,
        ProcessDetailedDTO process
) {

    public ProcessBadgeDetailedDTO(ProcessBadge processBadge) {
        this(processBadge.getIdProcessBadge() ,processBadge.getUrlBadge(), processBadge.getDateExpiration(),
                new ProcessDetailedDTO(processBadge.getProcess()));
    }

}
