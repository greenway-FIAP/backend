package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.ResourceTypeDetailedDTO;
import com.api.greenway.controllers.dtos.ResourceTypeRegisterDTO;
import com.api.greenway.controllers.dtos.ResourceTypeUpdateDTO;
import com.api.greenway.models.Process;
import com.api.greenway.models.ResourceType;
import com.api.greenway.services.ResourceTypeService;
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
@RequestMapping("/api/resource-type")
public class ResourceTypeController {

    private final ResourceTypeService resourceTypeService;

    @Autowired
    public ResourceTypeController(ResourceTypeService resourceTypeService) {
        this.resourceTypeService = resourceTypeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ResourceTypeRegisterDTO resourceTypeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        ResourceType resourceType = resourceTypeService.create(resourceTypeRegisterDTO);

        URI uri = uriBuilder.path("/api/resourceType/{id}").buildAndExpand(resourceType.getIdResourceType()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ResourceTypeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ResourceTypeDetailedDTO> page = resourceTypeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceTypeDetailedDTO> find(@PathVariable("id") Long id) {
        ResourceTypeDetailedDTO resourceTypeDetailedDTO = resourceTypeService.get(id);
        return ResponseEntity.ok(resourceTypeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        resourceTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceTypeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ResourceTypeUpdateDTO resourceTypeUpdateDTO) {
        ResourceTypeDetailedDTO resourceTypeDetailedDTO = resourceTypeService.update(id, resourceTypeUpdateDTO);
        return ResponseEntity.ok(resourceTypeDetailedDTO);
    }

}
