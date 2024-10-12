package com.api.greenway.controllers.dtos;

public record CompanyUpdateDTO(
        String name,

        String description,

        double currentRevenue,

        int size
) {
}
