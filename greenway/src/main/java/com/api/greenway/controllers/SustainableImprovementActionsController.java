package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.SustainableImprovementActions;
import com.api.greenway.services.SustainableImprovementActionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/api/sustainable-improvement-actions")
public class SustainableImprovementActionsController {

    private final SustainableImprovementActionsService sustainableImprovementActionsService;

    @Autowired
    public SustainableImprovementActionsController(SustainableImprovementActionsService sustainableImprovementActionsService) {
        this.sustainableImprovementActionsService = sustainableImprovementActionsService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SustainableImprovementActionsRegisterDTO sustainableImprovementActionsRegisterDTO, UriComponentsBuilder uriBuilder)  {
        SustainableImprovementActions sustainableImprovementActions = sustainableImprovementActionsService.create(sustainableImprovementActionsRegisterDTO);

        URI uri = uriBuilder.path("/api/sustainable-improvement-actions/{id}").buildAndExpand(sustainableImprovementActions.getIdSustainableImprovementActions()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<SustainableImprovementActionsDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Pageable pageable = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
        Page<SustainableImprovementActionsDetailedDTO> page = sustainableImprovementActionsService.list(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SustainableImprovementActionsDetailedDTO> find(@PathVariable("id") Long id) {
        SustainableImprovementActionsDetailedDTO sustainableImprovementActionsDetailedDTO = sustainableImprovementActionsService.get(id);
        return ResponseEntity.ok(sustainableImprovementActionsDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        sustainableImprovementActionsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SustainableImprovementActionsDetailedDTO> update(@PathVariable("id") Long id, @RequestBody SustainableImprovementActionsUpdateDTO sustainableImprovementActionsUpdateDTO) {
        SustainableImprovementActionsDetailedDTO sustainableImprovementActionsDetailedDTO = sustainableImprovementActionsService.update(id, sustainableImprovementActionsUpdateDTO);
        return ResponseEntity.ok(sustainableImprovementActionsDetailedDTO);
    }

}
