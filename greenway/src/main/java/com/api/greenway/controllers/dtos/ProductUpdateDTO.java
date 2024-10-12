package com.api.greenway.controllers.dtos;

public record ProductUpdateDTO(
        String name,

        String description,

        double salePrice,

        double costPrice,

        double weight
) {
}
