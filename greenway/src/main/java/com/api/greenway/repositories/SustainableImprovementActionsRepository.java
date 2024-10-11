package com.api.greenway.repositories;

import com.api.greenway.models.SustainableImprovementActions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SustainableImprovementActionsRepository extends JpaRepository<SustainableImprovementActions, Long> {

    Page<SustainableImprovementActions> findByFinishedAtIsNull(Pageable pagination);

    SustainableImprovementActions findOneByFinishedAtIsNullAndIdSustainableImprovementActions(Long idSustainableImprovementActions);

}
