package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProcessRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessUpdateDTO;
import com.api.greenway.controllers.dtos.ResourceTypeRegisterDTO;
import com.api.greenway.controllers.dtos.ResourceTypeUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "T_GRW_RESOURCE_TYPE")
@SequenceGenerator(name = "SEQ_GRW_RESOURCE_TYPE", sequenceName = "SEQ_GRW_RESOURCE_TYPE", allocationSize = 1)
public class ResourceType {

    @Column(name = "id_resource_type")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_RESOURCE_TYPE")
    private Long idResourceType;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public ResourceType(ResourceTypeRegisterDTO resourceTypeRegisterDTO){
        this.name = resourceTypeRegisterDTO.name();
        this.description = resourceTypeRegisterDTO.description();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(ResourceTypeUpdateDTO resourceTypeUpdateDTO) {
        if (resourceTypeUpdateDTO.name() != null) {
            this.name = resourceTypeUpdateDTO.name();
        }

        if (resourceTypeUpdateDTO.description() != null) {
            this.description = resourceTypeUpdateDTO.description();
        }

        this.updatedAt = LocalDateTime.now();

    }

}
