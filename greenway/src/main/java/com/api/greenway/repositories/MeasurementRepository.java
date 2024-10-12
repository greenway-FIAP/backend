package com.api.greenway.repositories;

import com.api.greenway.models.Measurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    Page<Measurement> findByFinishedAtIsNull(Pageable pagination);

    Measurement findOneByFinishedAtIsNullAndIdMeasurement(Long idMeasurement);

}