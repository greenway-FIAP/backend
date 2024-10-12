package com.api.greenway.repositories;

import com.api.greenway.models.ImprovementMeasurement;
import com.api.greenway.models.MeasurementProcessStep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementProcessStepRepository extends JpaRepository<MeasurementProcessStep, Long> {

    Page<MeasurementProcessStep> findByFinishedAtIsNull(Pageable pagination);

    MeasurementProcessStep findOneByFinishedAtIsNullAndIdMeasurementProcessStep(Long idMeasurementProcessStep);

}