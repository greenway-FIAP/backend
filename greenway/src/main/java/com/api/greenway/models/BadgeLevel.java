package com.api.greenway.models;

import com.api.greenway.controllers.dtos.BadgeLevelRegisterDTO;
import com.api.greenway.controllers.dtos.BadgeLevelUpdateDTO;
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
@Table(name = "T_GRW_BADGE_LEVEL")
@SequenceGenerator(name = "SEQ_GRW_BADGE_LEVEL", sequenceName = "SEQ_GRW_BADGE_LEVEL", allocationSize = 1)
public class BadgeLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_BADGE_LEVEL")
    @Column(name = "id_badge_level")
    private Long idBadgeLevel;

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

    public BadgeLevel(BadgeLevelRegisterDTO badgeLevelRegisterDTO) {
        this.name = badgeLevelRegisterDTO.name();
        this.description = badgeLevelRegisterDTO.description();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(BadgeLevelUpdateDTO badgeLevelUpdateDTO) {
        if (badgeLevelUpdateDTO.name() != null) {
            this.name = badgeLevelUpdateDTO.name();
        }

        if (badgeLevelUpdateDTO.description() != null) {
            this.description = badgeLevelUpdateDTO.description();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}