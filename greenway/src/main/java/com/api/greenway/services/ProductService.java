package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Process;
import com.api.greenway.models.Product;
import com.api.greenway.models.ProductType;
import com.api.greenway.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final ProcessService processService;

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductService(ProductRepository productRepository, ProcessService processService, ProductTypeService productTypeService) {
        this.productRepository = productRepository;
        this.processService = processService;
        this.productTypeService = productTypeService;
    }

    public Product create(ProductRegisterDTO productRegisterDTO) {
        Product product = new Product(productRegisterDTO);

        Process process = processService.find(productRegisterDTO.idProcess());

        ProductType productType = productTypeService.find(productRegisterDTO.idProductType());

        product.setProductType(productType);

        product.setProcess(process);

        return productRepository.save(product);
    }

    public Page<ProductDetailedDTO> list(Pageable pagination) {
        return productRepository.findByFinishedAtIsNull(pagination).map(ProductDetailedDTO::new);
    }

    public ProductDetailedDTO get(Long id) {
        return new ProductDetailedDTO(productRepository.findOneByFinishedAtIsNullAndIdProduct(id));
    }

    public void delete(Long id) {
        Product product = productRepository.findOneByFinishedAtIsNullAndIdProduct(id);

        product.disable();

        productRepository.save(product);
    }

    public ProductDetailedDTO update(Long id, ProductUpdateDTO productUpdateDTO) {
        Product product = productRepository.findOneByFinishedAtIsNullAndIdProduct(id);

        product.updateInformation(productUpdateDTO);

        productRepository.save(product);

        return new ProductDetailedDTO(product);
    }
}
