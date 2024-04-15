package com.api.greenway.models;

import com.api.greenway.controllers.dtos.ProductTypeRegisterDTO;
import com.api.greenway.controllers.dtos.ProductTypeUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "T_GRW_PRODUCT_TYPE")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
