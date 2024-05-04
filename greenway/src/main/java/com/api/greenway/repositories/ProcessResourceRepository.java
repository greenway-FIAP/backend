package com.api.greenway.repositories;

import com.api.greenway.models.ProcessResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessResourceRepository extends JpaRepository<ProcessResource, Long> {

    Page<ProcessResource> findByFinishedAtIsNull(Pageable pagination);

    ProcessResource findOneByFinishedAtIsNullAndIdProcessResource(Long idProcessResource);

}
