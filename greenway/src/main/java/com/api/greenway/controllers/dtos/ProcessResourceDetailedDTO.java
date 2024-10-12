package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ProcessResource;

import java.time.LocalDateTime;

public record ProcessResourceDetailedDTO(
        Long idProcessResource,
        LocalDateTime createdAt,
        ResourceDetailedDTO resource,

        ProcessDetailedDTO process

) {

    public ProcessResourceDetailedDTO(ProcessResource processResource) {
        this(processResource.getIdProcessResource(), processResource.getCreatedAt(),
                new ResourceDetailedDTO(processResource.getResource()),
                new ProcessDetailedDTO(processResource.getProcess())
        );
    }

}
