package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.StepDetailedDTO;
import com.api.greenway.controllers.dtos.StepRegisterDTO;
import com.api.greenway.controllers.dtos.StepUpdateDTO;
import com.api.greenway.models.Step;
import com.api.greenway.services.StepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/api/step")
public class StepController {

    private final StepService stepService;

    @Autowired
    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StepRegisterDTO stepRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Step step = stepService.create(stepRegisterDTO);

        URI uri = uriBuilder.path("/api/step/{id}").buildAndExpand(step.getIdStep()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<StepDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<StepDetailedDTO> page = stepService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StepDetailedDTO> find(@PathVariable("id") Long id) {
        StepDetailedDTO stepDetailedDTO = stepService.get(id);
        return ResponseEntity.ok(stepDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        stepService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StepDetailedDTO> update(@PathVariable("id") Long id, @RequestBody StepUpdateDTO stepUpdateDTO) {
        StepDetailedDTO stepDetailedDTO = stepService.update(id, stepUpdateDTO);
        return ResponseEntity.ok(stepDetailedDTO);
    }

}
