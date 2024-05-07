package com.api.greenway.repositories;

import com.api.greenway.models.CompanyRepresentative;
import com.api.greenway.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepresentativeRepository extends JpaRepository<CompanyRepresentative, Long> {

    Page<CompanyRepresentative> findByFinishedAtIsNull(Pageable pagination);

    CompanyRepresentative findOneByFinishedAtIsNullAndIdCompanyRepresentative(Long idCompanyRepresentative);

}
