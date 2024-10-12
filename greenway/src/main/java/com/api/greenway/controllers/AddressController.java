package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Address;
import com.api.greenway.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AddressRegisterDTO addressRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Address address = addressService.create(addressRegisterDTO);

        URI uri = uriBuilder.path("/api/address/{id}").buildAndExpand(address.getIdAddress()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<AddressDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<AddressDetailedDTO> page = addressService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDetailedDTO> find(@PathVariable("id") Long id) {
        AddressDetailedDTO addressDetailedDTO = addressService.get(id);
        return ResponseEntity.ok(addressDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDetailedDTO> update(@PathVariable("id") Long id, @RequestBody AddressUpdateDTO addressUpdateDTO) {
        AddressDetailedDTO addressDetailedDTO = addressService.update(id, addressUpdateDTO);
        return ResponseEntity.ok(addressDetailedDTO);
    }


}
