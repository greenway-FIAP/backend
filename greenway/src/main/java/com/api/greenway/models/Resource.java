package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ResourceRegisterDTO;
import com.api.greenway.controllers.dtos.ResourceUpdateDTO;
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
@Table(name = "T_GRW_RESOURCE")
@SequenceGenerator(name = "SEQ_GRW_RESOURCE", sequenceName = "SEQ_GRW_RESOURCE", allocationSize = 1)
public class Resource {

    @Column(name = "id_resource")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_RESOURCE")
    private Long idResource;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "vl_cost_per_unity")
    private Double costPerUnity;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "ds_unit_of_measurement")
    private String unitMeasurent;

    @Column(name = "nr_availability")
    private Double availability;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resource_type")
    private ResourceType resourceType;


    public Resource(ResourceRegisterDTO resourceRegisterDTO) {
        this.name = resourceRegisterDTO.name();
        this.costPerUnity = resourceRegisterDTO.costPerUnity();
        this.description = resourceRegisterDTO.description();
        this.unitMeasurent = resourceRegisterDTO.unitMeasurent();
        this.availability = resourceRegisterDTO.availability();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(ResourceUpdateDTO resourceUpdateDTO){
        if (resourceUpdateDTO.name() != null){
            this.name = resourceUpdateDTO.name();
        }
        if (resourceUpdateDTO.costPerUnity() != 0) {
            this.costPerUnity = resourceUpdateDTO.costPerUnity();
        }
        if (resourceUpdateDTO.description() != null) {
            this.description = resourceUpdateDTO.description();
        }
        if (resourceUpdateDTO.unitMeasurent() != null) {
            this.unitMeasurent = resourceUpdateDTO.unitMeasurent();
        }
        if (resourceUpdateDTO.availability() != 0) {
            this.availability = resourceUpdateDTO.availability();
        }

        this.updatedAt = LocalDateTime.now();

    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
