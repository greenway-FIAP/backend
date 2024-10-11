package com.api.greenway.models;

import com.api.greenway.controllers.dtos.SustainableImprovementActionsRegisterDTO;
import com.api.greenway.controllers.dtos.SustainableImprovementActionsUpdateDTO;
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
@Table(name = "T_GRW_SUSTAINABLE_IMPROVEMENT_ACTIONS")
@SequenceGenerator(name = "SEQ_GRW_SUSTAINABLE_IMPROVEMENT_ACTIONS", sequenceName = "SEQ_GRW_SUSTAINABLE_IMPROVEMENT_ACTIONS", allocationSize = 1)
public class SustainableImprovementActions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_SUSTAINABLE_IMPROVEMENT_ACTIONS")
    @Column(name = "id_sustainable_improvement_actions")
    private Long idSustainableImprovementActions;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_instruction")
    private String instruction;

    @Column(name = "st_sustainable_action")
    private StatusProcess statusProcess;

    @Column(name = "nr_priority")
    private Integer priority;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sustainable_goal")
    private SustainableGoal sustainableGoal;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public SustainableImprovementActions(SustainableImprovementActionsRegisterDTO sustainableImprovementActionsRegisterDTO) {
        this.name = sustainableImprovementActionsRegisterDTO.name();
        this.instruction = sustainableImprovementActionsRegisterDTO.instruction();
        this.statusProcess = sustainableImprovementActionsRegisterDTO.statusProcess();
        this.priority = sustainableImprovementActionsRegisterDTO.priority();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(SustainableImprovementActionsUpdateDTO sustainableImprovementActionsUpdateDTO) {
        if (sustainableImprovementActionsUpdateDTO.name() != null) {
            this.name = sustainableImprovementActionsUpdateDTO.name();
        }

        if (sustainableImprovementActionsUpdateDTO.instruction() != null) {
            this.instruction = sustainableImprovementActionsUpdateDTO.instruction();
        }

        if (sustainableImprovementActionsUpdateDTO.statusProcess() != null) {
            this.statusProcess = sustainableImprovementActionsUpdateDTO.statusProcess();
        }

        if (sustainableImprovementActionsUpdateDTO.priority() != null) {
            this.priority = sustainableImprovementActionsUpdateDTO.priority();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }


}
