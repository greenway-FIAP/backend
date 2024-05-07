package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Sector;

public record SectorDetailedDTO(
        Long idSector,
        String name,
        String description
) {
    public SectorDetailedDTO(Sector sector) {
        this(sector.getIdSector(), sector.getName(), sector.getDescription());
    }
}
