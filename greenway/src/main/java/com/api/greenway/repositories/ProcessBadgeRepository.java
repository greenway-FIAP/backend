package com.api.greenway.repositories;

import com.api.greenway.models.ProcessBadge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessBadgeRepository extends JpaRepository<ProcessBadge, Long> {
    Page<ProcessBadge> findByFinishedAtIsNull(Pageable pagination);

    ProcessBadge findOneByFinishedAtIsNullAndIdProcessBadge(Long idProcessBadge);
}
