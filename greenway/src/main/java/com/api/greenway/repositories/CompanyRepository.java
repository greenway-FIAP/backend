package com.api.greenway.repositories;

import com.api.greenway.models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findByFinishedAtIsNull(Pageable pagination);

    Company findOneByFinishedAtIsNullAndIdCompany(Long idCompany);
}
