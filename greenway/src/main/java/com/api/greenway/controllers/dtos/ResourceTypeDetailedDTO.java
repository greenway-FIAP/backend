package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ResourceType;

public record ResourceTypeDetailedDTO(
        Long idResourceType,

        String name,
        String description
) {
    public ResourceTypeDetailedDTO(ResourceType resourceType) {
        this(resourceType.getIdResourceType() ,resourceType.getName(), resourceType.getDescription());
    }
}
