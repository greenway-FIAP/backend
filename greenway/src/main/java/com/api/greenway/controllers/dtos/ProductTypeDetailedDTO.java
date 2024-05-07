package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ProductType;

public record ProductTypeDetailedDTO(
        Long idProductType,
        String name,
        String description
) {
    public ProductTypeDetailedDTO(ProductType productType) {
        this(productType.getIdProductType() ,productType.getName(), productType.getDescription());
    }
}
