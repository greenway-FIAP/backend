package com.api.greenway.repositories;

import com.api.greenway.models.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository  extends JpaRepository<Resource, Long> {

    Page<Resource> findByFinishedAtIsNull(Pageable pagination);
    Resource findOneByFinishedAtIsNullAndIdResource(Long idResource);

}
