package com.api.greenway.models;

import com.api.greenway.controllers.dtos.CompanyRepresentativeRegisterDTO;
import com.api.greenway.controllers.dtos.CompanyRepresentativeUpdateDTO;
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
@Table(name = "T_GRW_COMPANY_REPRESENTATIVE")
@SequenceGenerator(name = "SEQ_GRW_COMPANY_REPRESENTATIVE", sequenceName = "SEQ_GRW_COMPANY_REPRESENTATIVE", allocationSize = 1)
public class CompanyRepresentative {

    @Column(name = "id_company_representative")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_COMPANY_REPRESENTATIVE")
    private Long idCompanyRepresentative;

    @Column(name = "nr_phone")
    private String phone;

    @Column(name = "ds_role")
    private String role;

    @Column(name = "ds_name")
    private String name;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private Company company;

    public CompanyRepresentative(CompanyRepresentativeRegisterDTO companyRepresentativeRegisterDTO) {
        this.phone = companyRepresentativeRegisterDTO.phone();
        this.role = companyRepresentativeRegisterDTO.role();
        this.name = companyRepresentativeRegisterDTO.name();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(CompanyRepresentativeUpdateDTO companyRepresentativeUpdateDTO) {
        if (companyRepresentativeUpdateDTO.phone() != null) {
            this.phone = companyRepresentativeUpdateDTO.phone();
        }

        if (companyRepresentativeUpdateDTO.role() != null) {
            this.role = companyRepresentativeUpdateDTO.role();
        }

        if (companyRepresentativeUpdateDTO.name() != null) {
            this.name = companyRepresentativeUpdateDTO.name();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
