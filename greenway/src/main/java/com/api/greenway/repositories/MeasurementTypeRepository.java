package com.api.greenway.repositories;

import com.api.greenway.models.MeasurementType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Long> {
    Page<MeasurementType> findByFinishedAtIsNull(Pageable pagination);

    MeasurementType findOneByFinishedAtIsNullAndIdMeasurementType(Long idMeasurementType);
}