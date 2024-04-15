package com.api.greenway.controllers.dtos;

import com.api.greenway.models.ProductType;

public record ProductTypeDetailedDTO(
        String name,
        String description
) {
    public ProductTypeDetailedDTO(ProductType productType) {
        this(productType.getName(), productType.getDescription());
    }
}
