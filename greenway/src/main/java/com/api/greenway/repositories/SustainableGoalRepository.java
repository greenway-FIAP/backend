package com.api.greenway.repositories;

import com.api.greenway.models.SustainableGoal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SustainableGoalRepository extends JpaRepository<SustainableGoal, Long> {

    Page<SustainableGoal> findByFinishedAtIsNull(Pageable pagination);

    SustainableGoal findOneByFinishedAtIsNullAndIdSustainableGoal(Long idSustainableGoal);

}
