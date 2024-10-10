package com.api.greenway.models;

import com.api.greenway.controllers.dtos.BadgeRegisterDTO;
import com.api.greenway.controllers.dtos.BadgeUpdateDTO;
import com.api.greenway.controllers.dtos.ProcessRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessUpdateDTO;
import com.api.greenway.enums.StatusProcess;
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
@Table(name = "T_GRW_BADGE")
@SequenceGenerator(name = "SEQ_GRW_BADGE", sequenceName = "SEQ_GRW_BADGE", allocationSize = 1)
public class Badge {

    @Column(name = "id_badge")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_BADGE")
    private Long idBadge;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "ds_criteria")
    private String criteria;

    @Column(name = "st_badge")
    private StatusProcess statusProcess;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sustainable_goal")
    private SustainableGoal sustainableGoal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_badge_level")
    private BadgeLevel badgeLevel;

    public Badge(BadgeRegisterDTO badgeRegisterDTO) {
        this.name = badgeRegisterDTO.name();
        this.description = badgeRegisterDTO.description();
        this.criteria =  badgeRegisterDTO.criteria();
        this.statusProcess = badgeRegisterDTO.statusProcess();
        this.urlImage = badgeRegisterDTO.urlImage();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(BadgeUpdateDTO badgeUpdateDTO) {
        if (badgeUpdateDTO.name() != null) {
            this.name = badgeUpdateDTO.name();
        }

        if (badgeUpdateDTO.description() != null) {
            this.description = badgeUpdateDTO.description();
        }

        if(badgeUpdateDTO.criteria() != null) {
            this.criteria = badgeUpdateDTO.criteria();
        }

        if (badgeUpdateDTO.statusProcess() != null) {
            this.statusProcess = badgeUpdateDTO.statusProcess();
        }

        if (badgeUpdateDTO.urlImage() != null) {
            this.urlImage = badgeUpdateDTO.urlImage();
        }

        this.updatedAt = LocalDateTime.now();
    }

}
