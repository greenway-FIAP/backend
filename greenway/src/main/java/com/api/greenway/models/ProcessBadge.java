package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProcessBadgeRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessBadgeUpdateDTO;
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
@Table(name = "T_GRW_PROCESS_BADGE")
@SequenceGenerator(name = "SEQ_GRW_PROCESS_BADGE", sequenceName = "SEQ_GRW_PROCESS_BADGE", allocationSize = 1)
public class ProcessBadge {

    @Column(name = "id_process_badge")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_PROCESS_BADGE")
    private Long idProcessBadge;

    @Column(name = "dt_expiration_date")
    private LocalDateTime dateExpiration;

    @Column(name = "url_badge")
    private String urlBadge;

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
    @JoinColumn(name = "id_badge")
    private Badge badge;

    public ProcessBadge(ProcessBadgeRegisterDTO processBadgeRegisterDTO) {
        this.urlBadge = processBadgeRegisterDTO.urlBadge();
        this.dateExpiration =  processBadgeRegisterDTO.dateExpiration();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(ProcessBadgeUpdateDTO processBadgeUpdateDTO) {
        if (processBadgeUpdateDTO.urlBadge() != null) {
            this.urlBadge = processBadgeUpdateDTO.urlBadge();
        }

        if (processBadgeUpdateDTO.dateExpiration() != null) {
            this.dateExpiration = processBadgeUpdateDTO.dateExpiration();
        }

        this.updatedAt = LocalDateTime.now();
    }

}
