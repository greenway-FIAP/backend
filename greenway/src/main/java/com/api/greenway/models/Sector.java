package com.api.greenway.models;

import com.api.greenway.controllers.dtos.SectorRegisterDTO;
import com.api.greenway.controllers.dtos.SectorUpdateDTO;
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
@Table(name = "T_GRW_SECTOR")
public class Sector {
    @Column(name = "id_sector")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSector;

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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sector")
    private List<Company> companyList;

    public Sector(SectorRegisterDTO sectorRegisterDTO) {
        this.name = sectorRegisterDTO.name();
        this.description = sectorRegisterDTO.description();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(SectorUpdateDTO sectorUpdateDTO) {
        if (sectorUpdateDTO.name() != null) {
            this.name = sectorUpdateDTO.name();
        }

        if (sectorUpdateDTO.description() != null) {
            this.description = sectorUpdateDTO.description();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }
}
