package com.api.greenway.repositories;

import com.api.greenway.models.BadgeLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeLevelRepository extends JpaRepository<BadgeLevel, Long> {

    Page<BadgeLevel> findByFinishedAtIsNull(Pageable pagination);

    BadgeLevel findOneByFinishedAtIsNullAndIdBadgeLevel(Long idBadgeLevel);

}