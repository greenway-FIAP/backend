package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.CompanyRepresentative;
import com.api.greenway.services.CompanyRepresentativeService;
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
@RequestMapping("/api/company-representative")
public class CompanyRepresentativeController {

    private final CompanyRepresentativeService companyRepresentativeService;

    @Autowired
    public CompanyRepresentativeController(CompanyRepresentativeService companyRepresentativeService) {
        this.companyRepresentativeService = companyRepresentativeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CompanyRepresentativeRegisterDTO companyRepresentativeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        CompanyRepresentative companyRepresentative = companyRepresentativeService.create(companyRepresentativeRegisterDTO);

        URI uri = uriBuilder.path("/api/company-representative/{id}").buildAndExpand(companyRepresentative.getIdCompanyRepresentative()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<CompanyRepresentativeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<CompanyRepresentativeDetailedDTO> page = companyRepresentativeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyRepresentativeDetailedDTO> find(@PathVariable("id") Long id) {
        CompanyRepresentativeDetailedDTO companyRepresentativeDetailedDTO = companyRepresentativeService.get(id);
        return ResponseEntity.ok(companyRepresentativeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        companyRepresentativeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyRepresentativeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody CompanyRepresentativeUpdateDTO companyRepresentativeUpdateDTO) {
        CompanyRepresentativeDetailedDTO companyRepresentativeDetailedDTO = companyRepresentativeService.update(id, companyRepresentativeUpdateDTO);
        return ResponseEntity.ok(companyRepresentativeDetailedDTO);
    }

}
