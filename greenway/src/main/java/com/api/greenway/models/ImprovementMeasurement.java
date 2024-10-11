package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ImprovementMeasurementRegisterDTO;
import com.api.greenway.controllers.dtos.ImprovementMeasurementUpdateDTO;
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
@Table(name = "T_GRW_IMPROVEMENT_MEASUREMENT")
@SequenceGenerator(name = "SEQ_GRW_IMPROVEMENT_MEASUREMENT", sequenceName = "SEQ_GRW_IMPROVEMENT_MEASUREMENT", allocationSize = 1)
public class ImprovementMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_IMPROVEMENT_MEASUREMENT")
    @Column(name = "id_improvement_measurement")
    private Long idImprovementMeasurement;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sustainable_improvement_actions")
    private SustainableImprovementActions sustainableImprovementActions;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public ImprovementMeasurement(ImprovementMeasurementRegisterDTO improvementMeasurementRegisterDTO) {
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(ImprovementMeasurementUpdateDTO improvementMeasurementUpdateDTO) {
        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
