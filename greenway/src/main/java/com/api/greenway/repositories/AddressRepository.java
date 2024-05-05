package com.api.greenway.repositories;

import com.api.greenway.models.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findByFinishedAtIsNull(Pageable pagination);

    Address findOneByFinishedAtIsNullAndIdAddress(Long idAddress);

}
