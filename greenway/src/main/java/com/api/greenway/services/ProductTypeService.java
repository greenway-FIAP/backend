package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ProductType;
import com.api.greenway.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public ProductType find(Long id) {
        return productTypeRepository.findOneByFinishedAtIsNullAndIdProductType(id);
    }

    public ProductType create(ProductTypeRegisterDTO productTypeRegisterDTO) {
        return productTypeRepository.save(new ProductType(productTypeRegisterDTO));
    }

    public Page<ProductTypeDetailedDTO> list(Pageable pagination) {
        return productTypeRepository.findByFinishedAtIsNull(pagination).map(ProductTypeDetailedDTO::new);
    }

    public ProductTypeDetailedDTO get(Long id) {
        return new ProductTypeDetailedDTO(productTypeRepository.findOneByFinishedAtIsNullAndIdProductType(id));
    }

    public void delete(Long id) {
        ProductType productType = productTypeRepository.findOneByFinishedAtIsNullAndIdProductType(id);

        productType.disable();

        productTypeRepository.save(productType);
    }

    public ProductTypeDetailedDTO update(Long id, ProductTypeUpdateDTO productTypeUpdateDTO) {
        ProductType productType = productTypeRepository.findOneByFinishedAtIsNullAndIdProductType(id);

        productType.updateInformation(productTypeUpdateDTO);

        productTypeRepository.save(productType);

        return new ProductTypeDetailedDTO(productType);
    }
}
