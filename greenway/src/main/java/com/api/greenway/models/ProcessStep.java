package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProcessStepRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessStepUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "T_GRW_PROCESS_STEP")
@SequenceGenerator(name = "SEQ_GRW_PROCESS_STEP", sequenceName = "SEQ_GRW_PROCESS_STEP", allocationSize = 1)
public class ProcessStep {

    @Column(name = "id_process_step")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_PROCESS_STEP")
    private Long idProcessStep;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_process")
    private Process process;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_step")
    private Step step;

    public ProcessStep(ProcessStepRegisterDTO processStepRegisterDTO) {
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(ProcessStepUpdateDTO processStepUpdateDTO) {

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {this.finishedAt = LocalDateTime.now();}

}
