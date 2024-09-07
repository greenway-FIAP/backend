package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProductRegisterDTO;
import com.api.greenway.controllers.dtos.ProductUpdateDTO;
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
@Table(name = "T_GRW_PRODUCT")
@SequenceGenerator(name = "SEQ_GRW_PRODUCT", sequenceName = "SEQ_GRW_PRODUCT", allocationSize = 1)
public class Product {
    @Column(name = "id_product")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_PRODUCT")
    private Long idProduct;

    @Column(name = "ds_name")
    private String name;
    
    @Column(name = "tx_description")
    private String description;

    @Column(name = "vl_sale_price")
    private double salePrice;

    @Column(name = "vl_cost_price")
    private double costPrice;

    @Column(name = "nr_weight")
    private double weight;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product_type")
    private ProductType productType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_process")
    private Process process;

    public Product(ProductRegisterDTO productRegisterDTO) {
        this.name = productRegisterDTO.name();
        this.description = productRegisterDTO.description();
        this.salePrice = productRegisterDTO.salePrice();
        this.costPrice = productRegisterDTO.costPrice();
        this.weight = productRegisterDTO.weight();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(ProductUpdateDTO productUpdateDTO) {
        if (productUpdateDTO.name() != null) {
            this.name = productUpdateDTO.name();
        }

        if (productUpdateDTO.description() != null) {
            this.description = productUpdateDTO.description();
        }

        if (productUpdateDTO.salePrice() != 0) {
            this.salePrice = productUpdateDTO.salePrice();
        }

        if (productUpdateDTO.costPrice() != 0) {
            this.costPrice = productUpdateDTO.costPrice();
        }

        if (productUpdateDTO.weight() != 0) {
            this.weight = productUpdateDTO.weight();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }
}
