package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ProcessBadge;
import com.api.greenway.services.ProcessBadgeService;
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
@RequestMapping("/api/process-badge")
public class ProcessBadgeController {

    private final ProcessBadgeService processBadgeService;

    @Autowired
    public ProcessBadgeController(ProcessBadgeService processBadgeService) {
        this.processBadgeService = processBadgeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProcessBadgeRegisterDTO processBadgeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        ProcessBadge processBadge = processBadgeService.create(processBadgeRegisterDTO);

        URI uri = uriBuilder.path("/api/process-badge/{id}").buildAndExpand(processBadge.getIdProcessBadge()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProcessBadgeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ProcessBadgeDetailedDTO> page = processBadgeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessBadgeDetailedDTO> find(@PathVariable("id") Long id) {
        ProcessBadgeDetailedDTO processBadgeDetailedDTO = processBadgeService.get(id);
        return ResponseEntity.ok(processBadgeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        processBadgeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessBadgeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ProcessBadgeUpdateDTO processBadgeUpdateDTO) {
        ProcessBadgeDetailedDTO processBadgeDetailedDTO = processBadgeService.update(id, processBadgeUpdateDTO);
        return ResponseEntity.ok(processBadgeDetailedDTO);
    }

}
