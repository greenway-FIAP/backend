package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ProcessStep;
import com.api.greenway.services.ProcessStepService;
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
@RequestMapping("/api/processStep")
public class ProcessStepController {

    private final ProcessStepService processStepService;

    @Autowired
    public ProcessStepController(ProcessStepService processStepService) {
        this.processStepService = processStepService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProcessStepRegisterDTO processStepRegisterDTO, UriComponentsBuilder uriBuilder)  {
        ProcessStep processStep = processStepService.create(processStepRegisterDTO);

        URI uri = uriBuilder.path("/api/processStep/{id}").buildAndExpand(processStep.getIdProcessStep()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProcessStepDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ProcessStepDetailedDTO> page = processStepService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessStepDetailedDTO> find(@PathVariable("id") Long id) {
        ProcessStepDetailedDTO productDetailedDTO = processStepService.get(id);
        return ResponseEntity.ok(productDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        processStepService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessStepDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ProcessStepUpdateDTO processStepUpdateDTO) {
        ProcessStepDetailedDTO ProcessStepDetailedDTO = processStepService.update(id, processStepUpdateDTO);
        return ResponseEntity.ok(ProcessStepDetailedDTO);
    }
    
}
