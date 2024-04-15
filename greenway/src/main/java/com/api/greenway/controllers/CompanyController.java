package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Company;
import com.api.greenway.models.Process;
import com.api.greenway.services.CompanyService;
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
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CompanyRegisterDTO companyRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Company company = companyService.create(companyRegisterDTO);

        URI uri = uriBuilder.path("/api/company/{id}").buildAndExpand(company.getIdCompany()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<CompanyDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<CompanyDetailedDTO> page = companyService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailedDTO> find(@PathVariable("id") Long id) {
        CompanyDetailedDTO companyDetailedDTO = companyService.get(id);
        return ResponseEntity.ok(companyDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDetailedDTO> update(@PathVariable("id") Long id, @RequestBody CompanyUpdateDTO companyUpdateDTO) {
        CompanyDetailedDTO companyDetailedDTO = companyService.update(id, companyUpdateDTO);
        return ResponseEntity.ok(companyDetailedDTO);
    }
}
