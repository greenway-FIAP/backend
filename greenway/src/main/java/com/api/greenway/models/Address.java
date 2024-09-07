package com.api.greenway.models;

import com.api.greenway.controllers.dtos.AddressRegisterDTO;
import com.api.greenway.controllers.dtos.AddressUpdateDTO;
import com.api.greenway.controllers.dtos.CompanyRegisterDTO;
import com.api.greenway.controllers.dtos.CompanyUpdateDTO;
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
@Table(name = "T_GRW_ADDRESS")
@SequenceGenerator(name = "SEQ_GRW_ADDRESS", sequenceName = "SEQ_GRW_ADDRESS", allocationSize = 1)
public class Address {

    @Column(name = "id_address")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_ADDRESS")
    private Long idAddress;

    @Column(name = "ds_street")
    private String street;

    @Column(name = "ds_zip_code")
    private String zipCode;

    @Column(name = "ds_number")
    private String number;

    @Column(name = "ds_uf")
    private String uf;

    @Column(name = "ds_neighborhood")
    private String neighborhood;

    @Column(name = "ds_city")
    private String city;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private Company company;

    public Address(AddressRegisterDTO addressRegisterDTO) {
        this.street = addressRegisterDTO.street();
        this.zipCode = addressRegisterDTO.zipCode();
        this.number = addressRegisterDTO.number();
        this.uf = addressRegisterDTO.uf();
        this.neighborhood = addressRegisterDTO.neighborhood();
        this.city = addressRegisterDTO.city();
        this.createdAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

    public void updateInformation(AddressUpdateDTO addressUpdateDTO) {
        if (addressUpdateDTO.street() != null) {
            this.street = addressUpdateDTO.street();
        }
        if (addressUpdateDTO.zipCode() != null) {
            this.zipCode = addressUpdateDTO.zipCode();
        }
        if (addressUpdateDTO.number() != null) {
            this.number = addressUpdateDTO.number();
        }
        if (addressUpdateDTO.uf() != null) {
            this.uf = addressUpdateDTO.uf();
        }
        if (addressUpdateDTO.neighborhood() != null) {
            this.neighborhood = addressUpdateDTO.neighborhood();
        }
        if (addressUpdateDTO.city() != null) {
            this.city = addressUpdateDTO.city();
        }

        this.updatedAt = LocalDateTime.now();
    }

}
