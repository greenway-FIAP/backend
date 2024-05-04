package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.ProcessResourceRegisterDTO;
import com.api.greenway.controllers.dtos.ProcessResourceDetailedDTO;
import com.api.greenway.controllers.dtos.ProcessResourceUpdateDTO;
import com.api.greenway.controllers.dtos.ProductUpdateDTO;
import com.api.greenway.models.ProcessResource;
import com.api.greenway.services.ProcessResourceService;
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
@RequestMapping("/api/processResource")
public class ProcessResourceController {

    private final ProcessResourceService processResourceService;

    @Autowired
    public ProcessResourceController(ProcessResourceService processResourceService) {
        this.processResourceService = processResourceService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProcessResourceRegisterDTO processResourceRegisterDTO, UriComponentsBuilder uriBuilder)  {
        ProcessResource processResource = processResourceService.create(processResourceRegisterDTO);

        URI uri = uriBuilder.path("/api/processResource/{id}").buildAndExpand(processResource.getIdProcessResource()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProcessResourceDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ProcessResourceDetailedDTO> page = processResourceService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessResourceDetailedDTO> find(@PathVariable("id") Long id) {
        ProcessResourceDetailedDTO productDetailedDTO = processResourceService.get(id);
        return ResponseEntity.ok(productDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        processResourceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessResourceDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ProcessResourceUpdateDTO processResourceUpdateDTO) {
        ProcessResourceDetailedDTO processResourceDetailedDTO = processResourceService.update(id, processResourceUpdateDTO);
        return ResponseEntity.ok(processResourceDetailedDTO);
    }



}
