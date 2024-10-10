package com.api.greenway.models;

import com.api.greenway.controllers.dtos.MeasurementTypeRegisterDTO;
import com.api.greenway.controllers.dtos.MeasurementTypeUpdateDTO;
import com.api.greenway.controllers.dtos.SectorRegisterDTO;
import com.api.greenway.controllers.dtos.SectorUpdateDTO;
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
@Table(name = "T_GRW_MEASUREMENT_TYPE")
@SequenceGenerator(name = "SEQ_GRW_MEASUREMENT_TYPE", sequenceName = "SEQ_GRW_MEASUREMENT_TYPE", allocationSize = 1)
public class MeasurementType {

    @Column(name = "id_measurement_type")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_MEASUREMENT_TYPE")
    private Long idMeasurementType;

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

    public MeasurementType(MeasurementTypeRegisterDTO measurementTypeRegisterDTO) {
        this.name = measurementTypeRegisterDTO.name();
        this.description = measurementTypeRegisterDTO.description();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(MeasurementTypeUpdateDTO measurementTypeUpdateDTO) {
        if (measurementTypeUpdateDTO.name() != null) {
            this.name = measurementTypeUpdateDTO.name();
        }

        if (measurementTypeUpdateDTO.description() != null) {
            this.description = measurementTypeUpdateDTO.description();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
