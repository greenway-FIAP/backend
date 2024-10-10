package com.api.greenway.repositories;

import com.api.greenway.models.Badge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    Page<Badge> findByFinishedAtIsNull(Pageable pagination);

    Badge findOneByFinishedAtIsNullAndIdBadge(Long idBadge);
}
