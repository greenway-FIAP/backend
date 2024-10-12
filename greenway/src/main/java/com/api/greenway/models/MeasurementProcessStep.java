package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ImprovementMeasurementRegisterDTO;
import com.api.greenway.controllers.dtos.ImprovementMeasurementUpdateDTO;
import com.api.greenway.controllers.dtos.MeasurementProcessStepRegisterDTO;
import com.api.greenway.controllers.dtos.MeasurementProcessStepUpdateDTO;
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
@Table(name = "T_GRW_MEASUREMENT_PROCESS_STEP")
@SequenceGenerator(name = "SEQ_GRW_MEASUREMENT_PROCESS_STEP", sequenceName = "SEQ_GRW_MEASUREMENT_PROCESS_STEP", allocationSize = 1)
public class MeasurementProcessStep {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_MEASUREMENT_PROCESS_STEP")
    @Column(name = "id_measurement_process_step")
    private Long idMeasurementProcessStep;

    @Column(name = "nr_result")
    private Double result;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_process_step")
    private ProcessStep processStep;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_measurement")
    private Measurement measurement;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public MeasurementProcessStep(MeasurementProcessStepRegisterDTO measurementProcessStepRegisterDTO) {

        if (measurementProcessStepRegisterDTO.result() != 0) {
            this.result = measurementProcessStepRegisterDTO.result();
        }

        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(MeasurementProcessStepUpdateDTO measurementProcessStepUpdateDTO) {

        if (measurementProcessStepUpdateDTO.result() != 0) {
            this.result = measurementProcessStepUpdateDTO.result();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }


}
