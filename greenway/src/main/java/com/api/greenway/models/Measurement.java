package com.api.greenway.models;

import com.api.greenway.controllers.dtos.MeasurementRegisterDTO;
import com.api.greenway.controllers.dtos.MeasurementUpdateDTO;
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
@Table(name = "T_GRW_MEASUREMENT")
@SequenceGenerator(name = "SEQ_GRW_MEASUREMENT", sequenceName = "SEQ_GRW_MEASUREMENT", allocationSize = 1)
public class Measurement {

    @Column(name = "id_measurement")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_MEASUREMENT")
    private Long idMeasurement;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_measurement_type")
    private MeasurementType measurementType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sustainable_goal")
    private SustainableGoal sustainableGoal;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime finishedAt;

    public Measurement(MeasurementRegisterDTO measurementRegisterDTO) {
        this.name = measurementRegisterDTO.name();
        this.description = measurementRegisterDTO.description();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(MeasurementUpdateDTO measurementUpdateDTO) {
        if (measurementUpdateDTO.name() != null) {
            this.name = measurementUpdateDTO.name();
        }

        if (measurementUpdateDTO.description() != null) {
            this.description = measurementUpdateDTO.description();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
