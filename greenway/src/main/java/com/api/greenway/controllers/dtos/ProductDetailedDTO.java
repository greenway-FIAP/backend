package com.api.greenway.controllers.dtos;

import com.api.greenway.models.Product;

import java.time.LocalDateTime;
import java.util.List;

public record ProductDetailedDTO(
        Long idProduct,
        String name,
        String description,
        double salePrice,
        double costPrice,
        double weight,
        LocalDateTime createdAt,
        ProductTypeDetailedDTO productType
) {
    public ProductDetailedDTO(Product product) {
        this(product.getIdProduct() ,product.getName(), product.getDescription(), product.getSalePrice(), product.getCostPrice(), product.getWeight(), product.getCreatedAt(),
                new ProductTypeDetailedDTO(product.getProductType()));
    }
}
