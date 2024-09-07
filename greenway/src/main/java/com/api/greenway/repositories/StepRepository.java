package com.api.greenway.repositories;

import com.api.greenway.models.Step;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {

    Page<Step> findByFinishedAtIsNull(Pageable pagination);

    Step findOneByFinishedAtIsNullAndIdStep(Long idStep);

}
