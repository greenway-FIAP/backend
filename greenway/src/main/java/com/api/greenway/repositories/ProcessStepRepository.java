package com.api.greenway.repositories;

import com.api.greenway.models.ProcessStep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessStepRepository extends JpaRepository<ProcessStep, Long> {

    Page<ProcessStep> findByFinishedAtIsNull(Pageable pagination);

    ProcessStep findOneByFinishedAtIsNullAndIdProcessStep(Long idProcessStep);

}
