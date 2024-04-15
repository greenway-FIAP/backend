package com.api.greenway.models;

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
@Table(name = "T_GRW_PROCESS")
public class Process {
    @Column(name = "id_process")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProcess;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "st_process")
    private StatusProcess statusProcess;

    @Column(name = "nr_priority")
    private int priority;

    @Column(name = "dt_start")
    private LocalDateTime dateStart;

    @Column(name = "dt_end")
    private LocalDateTime dateEnd;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "tx_comments")
    private String comments;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_process")
    private List<Product> productList;

    public Process(ProcessRegisterDTO processRegisterDTO) {
        this.name = processRegisterDTO.name();
        this.comments = processRegisterDTO.comments();
        this.dateEnd =  processRegisterDTO.dateEnd();
        this.dateStart = processRegisterDTO.dateStart();
        this.description = processRegisterDTO.description();
        this.priority = processRegisterDTO.priority();
        this.statusProcess = processRegisterDTO.statusProcess();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(ProcessUpdateDTO processUpdateDTO) {
        if (processUpdateDTO.name() != null) {
            this.name = processUpdateDTO.name();
        }

        if (processUpdateDTO.description() != null) {
            this.description = processUpdateDTO.description();
        }

        if(processUpdateDTO.statusProcess() != null) {
            this.statusProcess = processUpdateDTO.statusProcess();
        }

        if (processUpdateDTO.priority() != 0) {
            this.priority = processUpdateDTO.priority();
        }

        if (processUpdateDTO.dateStart() != null) {
            this.dateStart = processUpdateDTO.dateStart();
        }

        if (processUpdateDTO.dateEnd() != null) {
            this.dateEnd = processUpdateDTO.dateEnd();
        }

        if (processUpdateDTO.comments() != null) {
            this.comments = processUpdateDTO.comments();
        }

        this.updatedAt = LocalDateTime.now();
    }
}
