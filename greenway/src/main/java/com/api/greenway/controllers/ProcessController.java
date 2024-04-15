package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Process;
import com.api.greenway.services.ProcessService;
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
@RequestMapping("/api/process")
public class ProcessController {
    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProcessRegisterDTO processRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Process process = processService.create(processRegisterDTO);

        URI uri = uriBuilder.path("/api/process/{id}").buildAndExpand(process.getIdProcess()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProcessDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ProcessDetailedDTO> page = processService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessDetailedDTO> find(@PathVariable("id") Long id) {
        ProcessDetailedDTO processDetailedDTO = processService.get(id);
        return ResponseEntity.ok(processDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        processService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ProcessUpdateDTO processUpdateDTO) {
        ProcessDetailedDTO processDetailedDTO = processService.update(id, processUpdateDTO);
        return ResponseEntity.ok(processDetailedDTO);
    }
}
