package com.api.greenway.repositories;

import com.api.greenway.models.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    Page<UserType> findByFinishedAtIsNull(Pageable pagination);

    UserType findOneByFinishedAtIsNullAndIdUserType(Long idUserType);
}
