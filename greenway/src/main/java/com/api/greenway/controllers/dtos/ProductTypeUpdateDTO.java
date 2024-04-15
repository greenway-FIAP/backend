package com.api.greenway.controllers.dtos;

import java.time.LocalDateTime;

public record ProductTypeUpdateDTO(
        String name,
        String description
) {
}
