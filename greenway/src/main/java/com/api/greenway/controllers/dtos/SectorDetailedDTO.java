package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Sector;

public record SectorDetailedDTO(
        String name,
        String description
) {
    public SectorDetailedDTO(Sector sector) {
        this(sector.getName(), sector.getDescription());
    }
}
