package com.api.greenway.models;

import com.api.greenway.controllers.dtos.StepRegisterDTO;
import com.api.greenway.controllers.dtos.StepUpdateDTO;
import com.api.greenway.enums.StatusProcess;
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
@Table(name = "T_GRW_STEP")
@SequenceGenerator(name = "SEQ_GRW_STEP", sequenceName = "SEQ_GRW_STEP", allocationSize = 1)
public class Step {
    @Column(name = "id_step")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_STEP")
    private Long idStep;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "nr_estimated_time")
    private int estimatedTime;

    @Column(name = "st_step")
    private StatusProcess statusStep;

    @Column(name = "dt_start")
    private LocalDateTime dateStart;

    @Column(name = "dt_end")
    private LocalDateTime dateEnd;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public Step(StepRegisterDTO stepRegisterDTO) {
        this.name = stepRegisterDTO.name();
        this.estimatedTime = stepRegisterDTO.estimatedTime();
        this.description = stepRegisterDTO.description();
        this.statusStep = stepRegisterDTO.statusStep();
        this.dateEnd =  stepRegisterDTO.dateEnd();
        this.dateStart = stepRegisterDTO.dateStart();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(StepUpdateDTO stepUpdateDTO) {
        if (stepUpdateDTO.name() != null) {
            this.name = stepUpdateDTO.name();
        }

        if (stepUpdateDTO.estimatedTime() != 0) {
            this.estimatedTime = stepUpdateDTO.estimatedTime();
        }

        if (stepUpdateDTO.description() != null) {
            this.description = stepUpdateDTO.description();
        }

        if(stepUpdateDTO.statusStep() != null) {
            this.statusStep = stepUpdateDTO.statusStep();
        }

        if (stepUpdateDTO.dateStart() != null) {
            this.dateStart = stepUpdateDTO.dateStart();
        }

        if (stepUpdateDTO.dateEnd() != null) {
            this.dateEnd = stepUpdateDTO.dateEnd();
        }

        this.updatedAt = LocalDateTime.now();
    }

}
