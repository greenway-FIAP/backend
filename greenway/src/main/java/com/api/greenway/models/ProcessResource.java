package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProcessResourceRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessResourceUpdateDTO;
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
@Table(name = "T_GRW_PROCESS_RESOURCE")
public class ProcessResource {

    @Column(name = "id_process_resource")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProcessResource;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resource")
    private Resource resource;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_process")
    private Process process;

    public ProcessResource(ProcessResourceRegisterDTO processResourceRegisterDTO) {
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(ProcessResourceUpdateDTO processResourceUpdateDTO) {

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {this.finishedAt = LocalDateTime.now();}

}
