package com.api.greenway.repositories;

import com.api.greenway.models.ImprovementMeasurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImprovementMeasurementRepository extends JpaRepository<ImprovementMeasurement, Long> {

    Page<ImprovementMeasurement> findByFinishedAtIsNull(Pageable pagination);

    ImprovementMeasurement findOneByFinishedAtIsNullAndIdImprovementMeasurement(Long idImprovementMeasurement);

}
