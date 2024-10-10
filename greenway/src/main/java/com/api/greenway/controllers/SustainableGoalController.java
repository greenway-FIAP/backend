package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.SustainableGoal;
import com.api.greenway.services.SustainableGoalService;
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
@RequestMapping("/api/sustainable-goal")
public class SustainableGoalController {

    private final SustainableGoalService sustainableGoalService;

    @Autowired
    public SustainableGoalController(SustainableGoalService sustainableGoalService) {
        this.sustainableGoalService = sustainableGoalService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SustainableGoalRegisterDTO sustainableGoalRegisterDTO, UriComponentsBuilder uriBuilder)  {
        SustainableGoal sustainableGoal = sustainableGoalService.create(sustainableGoalRegisterDTO);

        URI uri = uriBuilder.path("/api/sustainable-goal/{id}").buildAndExpand(sustainableGoal.getIdSustainableGoal()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<SustainableGoalDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<SustainableGoalDetailedDTO> page = sustainableGoalService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SustainableGoalDetailedDTO> find(@PathVariable("id") Long id) {
        SustainableGoalDetailedDTO sustainableGoalDetailedDTO = sustainableGoalService.get(id);
        return ResponseEntity.ok(sustainableGoalDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        sustainableGoalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SustainableGoalDetailedDTO> update(@PathVariable("id") Long id, @RequestBody SustainableGoalUpdateDTO sustainableGoalUpdateDTO) {
        SustainableGoalDetailedDTO sustainableGoalDetailedDTO = sustainableGoalService.update(id, sustainableGoalUpdateDTO);
        return ResponseEntity.ok(sustainableGoalDetailedDTO);
    }

}
