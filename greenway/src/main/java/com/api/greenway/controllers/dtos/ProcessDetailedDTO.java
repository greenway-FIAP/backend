package com.api.greenway.controllers.dtos;

import com.api.greenway.enums.StatusProcess;
import com.api.greenway.models.Process;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record ProcessDetailedDTO(

        Long idProcess,
        String name,

        String description,

        StatusProcess statusProcess,

        int priority,

        LocalDateTime dateStart,

        LocalDateTime dateEnd,

        String comments,

        List<ProductDetailedDTO> productList
) {
    public ProcessDetailedDTO(Process process) {
        this(process.getIdProcess() ,process.getName(), process.getDescription(), process.getStatusProcess(), process.getPriority(),
                process.getDateStart(), process.getDateEnd(), process.getComments(), process.getProductList().stream().map(ProductDetailedDTO::new).toList());
    }
}
