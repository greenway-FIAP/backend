package com.api.greenway.repositories;

import com.api.greenway.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByFinishedAtIsNull(Pageable pagination);

    User findOneByFinishedAtIsNullAndIdUser(Long idUser);

    Optional<User> findByEmail(String email);
}
