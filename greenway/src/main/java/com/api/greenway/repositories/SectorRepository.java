package com.api.greenway.repositories;

import com.api.greenway.models.Sector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    Page<Sector> findByFinishedAtIsNull(Pageable pagination);

    Sector findOneByFinishedAtIsNullAndIdSector(Long idSector);
}
