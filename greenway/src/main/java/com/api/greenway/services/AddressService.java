package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Address;
import com.api.greenway.models.Company;
import com.api.greenway.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private final CompanyService companyService;

    @Autowired
    public AddressService(AddressRepository addressRepository, CompanyService companyService) {
        this.addressRepository = addressRepository;
        this.companyService = companyService;
    }

    public Address find(Long id) {
        return addressRepository.findOneByFinishedAtIsNullAndIdAddress(id);
    }

    public Address create(AddressRegisterDTO addressRegisterDTO) {
        Address address = new Address(addressRegisterDTO);

        Company company = companyService.find(addressRegisterDTO.idCompany());

        address.setCompany(company);

        return addressRepository.save(address);
    }

    public Page<AddressDetailedDTO> list(Pageable pagination) {
        return addressRepository.findByFinishedAtIsNull(pagination).map(AddressDetailedDTO::new);
    }

    public AddressDetailedDTO get(Long id) {
        return new AddressDetailedDTO(addressRepository.findOneByFinishedAtIsNullAndIdAddress(id));
    }

    public void delete(Long id) {
        Address address = addressRepository.findOneByFinishedAtIsNullAndIdAddress(id);

        address.disable();

        addressRepository.save(address);
    }

    public AddressDetailedDTO update(Long id, AddressUpdateDTO addressUpdateDTO) {
        Address address = addressRepository.findOneByFinishedAtIsNullAndIdAddress(id);

        address.updateInformation(addressUpdateDTO);

        addressRepository.save(address);

        return new AddressDetailedDTO(address);
    }


}
