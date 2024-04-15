package com.api.greenway.repositories;

import com.api.greenway.models.Company;
import com.api.greenway.models.Process;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    Page<Process> findByFinishedAtIsNull(Pageable pagination);

    Process findOneByFinishedAtIsNullAndIdProcess(Long idProcess);
}
