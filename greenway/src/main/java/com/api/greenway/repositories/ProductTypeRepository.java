package com.api.greenway.repositories;

import com.api.greenway.models.Company;
import com.api.greenway.models.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    Page<ProductType> findByFinishedAtIsNull(Pageable pagination);

    ProductType findOneByFinishedAtIsNullAndIdProductType(Long idProductType);
}
