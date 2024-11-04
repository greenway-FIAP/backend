package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.ProductDetailedDTO;
import com.api.greenway.controllers.dtos.ProductRegisterDTO;
import com.api.greenway.controllers.dtos.ProductUpdateDTO;
import com.api.greenway.models.Product;
import com.api.greenway.services.ProductService;
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
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductRegisterDTO productRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Product product = productService.create(productRegisterDTO);

        URI uri = uriBuilder.path("/api/product/{id}").buildAndExpand(product.getIdProduct()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ProductDetailedDTO> page = productService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailedDTO> find(@PathVariable("id") Long id) {
        ProductDetailedDTO productDetailedDTO = productService.get(id);
        return ResponseEntity.ok(productDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ProductUpdateDTO productTypeUpdateDTO) {
        ProductDetailedDTO productDetailedDTO = productService.update(id, productTypeUpdateDTO);
        return ResponseEntity.ok(productDetailedDTO);
    }
}
