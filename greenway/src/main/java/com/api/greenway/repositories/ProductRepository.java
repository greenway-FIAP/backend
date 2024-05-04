package com.api.greenway.repositories;

import com.api.greenway.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByFinishedAtIsNull(Pageable pagination);

    Product findOneByFinishedAtIsNullAndIdProduct(Long idProduct);
}
