package com.api.greenway.models;

import com.api.greenway.controllers.dtos.CompanyRegisterDTO;
import com.api.greenway.controllers.dtos.CompanyUpdateDTO;
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
@Table(name = "T_GRW_COMPANY")
@SequenceGenerator(name = "SEQ_GRW_COMPANY", sequenceName = "SEQ_GRW_COMPANY", allocationSize = 1)
public class Company {
    @Column(name = "id_company")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_COMPANY")
    private Long idCompany;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "tx_description")
    private String description;

    @Column(name = "vl_current_revenue")
    private double currentRevenue;

    @Column(name = "nr_size")
    private int size;

    @Column(name = "nr_cnpj")
    private String cnpj;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sector")
    private Sector sector;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private List<Process> processList;

    public Company(CompanyRegisterDTO companyRegisterDTO) {
        this.cnpj = companyRegisterDTO.cnpj();
        this.name = companyRegisterDTO.name();
        this.description = companyRegisterDTO.description();
        this.currentRevenue = companyRegisterDTO.currentRevenue();
        this.size = companyRegisterDTO.size();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(CompanyUpdateDTO companyUpdateDTO) {
        if (companyUpdateDTO.name() != null) {
            this.name = companyUpdateDTO.name();
        }

        if (companyUpdateDTO.description() != null) {
            this.description = companyUpdateDTO.description();
        }

        if (companyUpdateDTO.currentRevenue() == 0) {
            this.currentRevenue = companyUpdateDTO.currentRevenue();
        }

        if (companyUpdateDTO.size() != 0) {
            this.size = companyUpdateDTO.size();
        }

        this.updatedAt = LocalDateTime.now();
    }
}
