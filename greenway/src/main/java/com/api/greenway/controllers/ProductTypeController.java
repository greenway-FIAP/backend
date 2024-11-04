package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ProductType;
import com.api.greenway.services.ProductTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/api/product-type")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductTypeRegisterDTO productTypeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        ProductType productType = productTypeService.create(productTypeRegisterDTO);

        URI uri = uriBuilder.path("/api/product-type/{id}").buildAndExpand(productType.getIdProductType()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductTypeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ProductTypeDetailedDTO> page = productTypeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeDetailedDTO> find(@PathVariable("id") Long id) {
        ProductTypeDetailedDTO productTypeDetailedDTO = productTypeService.get(id);
        return ResponseEntity.ok(productTypeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ProductTypeUpdateDTO productTypeUpdateDTO) {
        ProductTypeDetailedDTO productTypeDetailedDTO = productTypeService.update(id, productTypeUpdateDTO);
        return ResponseEntity.ok(productTypeDetailedDTO);
    }
}
