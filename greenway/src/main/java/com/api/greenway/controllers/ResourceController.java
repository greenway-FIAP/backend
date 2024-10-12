package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.ResourceDetailedDTO;
import com.api.greenway.controllers.dtos.ResourceRegisterDTO;
import com.api.greenway.controllers.dtos.ResourceUpdateDTO;
import com.api.greenway.models.Resource;
import com.api.greenway.services.ResourceService;
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
@RequestMapping("/api/resource")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ResourceRegisterDTO resourceRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Resource resource = resourceService.create(resourceRegisterDTO);

        URI uri = uriBuilder.path("/api/resource/{id}").buildAndExpand(resource.getIdResource()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ResourceDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ResourceDetailedDTO> page = resourceService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDetailedDTO> find(@PathVariable("id") Long id) {
        ResourceDetailedDTO resourceDetailedDTO = resourceService.get(id);
        return ResponseEntity.ok(resourceDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        resourceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ResourceUpdateDTO resourceUpdateDTO) {
        ResourceDetailedDTO resourceDetailedDTO = resourceService.update(id, resourceUpdateDTO);
        return ResponseEntity.ok(resourceDetailedDTO);
    }

}
