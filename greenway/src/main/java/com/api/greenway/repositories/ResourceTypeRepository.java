package com.api.greenway.repositories;

import com.api.greenway.models.ResourceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceTypeRepository extends JpaRepository<ResourceType, Long> {

    Page<ResourceType> findByFinishedAtIsNull(Pageable pagination);

    ResourceType findOneByFinishedAtIsNullAndIdResourceType(Long idResourceType);

}
