package com.api.greenway.models;

import com.api.greenway.controllers.dtos.SustainableGoalRegisterDTO;
import com.api.greenway.controllers.dtos.SustainableGoalUpdateDTO;
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
@Table(name = "T_GRW_SUSTAINABLE_GOAL")
@SequenceGenerator(name = "SEQ_GRW_SUSTAINABLE_GOAL", sequenceName = "SEQ_GRW_SUSTAINABLE_GOAL", allocationSize = 1)
public class SustainableGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_SUSTAINABLE_GOAL")
    @Column(name = "id_sustainable_goal")
    private Long idSustainableGoal;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "vl_target")
    private double target;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public SustainableGoal(SustainableGoalRegisterDTO sustainableGoalRegisterDTO) {
        this.name = sustainableGoalRegisterDTO.name();
        this.description = sustainableGoalRegisterDTO.description();
        this.target = sustainableGoalRegisterDTO.target();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(SustainableGoalUpdateDTO sustainableGoalUpdateDTO) {
        if (sustainableGoalUpdateDTO.name() != null) {
            this.name = sustainableGoalUpdateDTO.name();
        }

        if (sustainableGoalUpdateDTO.description() != null) {
            this.description = sustainableGoalUpdateDTO.description();
        }

        if (sustainableGoalUpdateDTO.target() != null) {
            this.target = sustainableGoalUpdateDTO.target();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }


}
