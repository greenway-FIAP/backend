package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProductTypeRegisterDTO;
import com.api.greenway.controllers.dtos.ProductTypeUpdateDTO;
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
@Table(name = "T_GRW_PRODUCT_TYPE")
@SequenceGenerator(name = "SEQ_GRW_PRODUCT_TYPE", sequenceName = "SEQ_GRW_PRODUCT_TYPE", allocationSize = 1)
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_PRODUCT_TYPE")
    @Column(name = "id_product_type")
    private Long idProductType;

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
    @JoinColumn(name = "id_product_type")
    private List<Product> productList;

    public ProductType(ProductTypeRegisterDTO productTypeRegisterDTO) {
        this.name = productTypeRegisterDTO.name();
        this.description = productTypeRegisterDTO.description();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(ProductTypeUpdateDTO productTypeUpdateDTO) {
        if (productTypeUpdateDTO.name() != null) {
            this.name = productTypeUpdateDTO.name();
        }

        if (productTypeUpdateDTO.description() != null) {
            this.description = productTypeUpdateDTO.description();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }
}
