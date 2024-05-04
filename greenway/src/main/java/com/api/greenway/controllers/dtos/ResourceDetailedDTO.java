package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Resource;

import java.time.LocalDateTime;

public record ResourceDetailedDTO(
        Long idResource,
        String name,
        double costPerUnity,
        String description,
        String unitMeasurent,
        double availability,
        LocalDateTime createdAt,
        ResourceTypeDetailedDTO resourceType
) {

    public ResourceDetailedDTO(Resource resource) {
        this(resource.getIdResource(), resource.getName(), resource.getCostPerUnity(), resource.getDescription(), resource.getUnitMeasurent(), resource.getAvailability(), resource.getCreatedAt(), new ResourceTypeDetailedDTO(resource.getResourceType()));
    }

}
