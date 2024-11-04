package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.MeasurementProcessStep;
import com.api.greenway.services.MeasurementProcessStepService;
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
@RequestMapping("/api/measurement-process-step")
public class MeasurementProcessStepController {

    private final MeasurementProcessStepService measurementProcessStepService;

    @Autowired
    public MeasurementProcessStepController(MeasurementProcessStepService measurementProcessStepService) {
        this.measurementProcessStepService = measurementProcessStepService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid MeasurementProcessStepRegisterDTO measurementProcessStepRegisterDTO, UriComponentsBuilder uriBuilder)  {
        MeasurementProcessStep measurementProcessStep = measurementProcessStepService.create(measurementProcessStepRegisterDTO);

        URI uri = uriBuilder.path("/api/measurement-process-step/{id}").buildAndExpand(measurementProcessStep.getIdMeasurementProcessStep()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<MeasurementProcessStepDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Pageable pageable = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
        Page<MeasurementProcessStepDetailedDTO> page = measurementProcessStepService.list(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementProcessStepDetailedDTO> find(@PathVariable("id") Long id) {
        MeasurementProcessStepDetailedDTO measurementProcessStepDetailedDTO = measurementProcessStepService.get(id);
        return ResponseEntity.ok(measurementProcessStepDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        measurementProcessStepService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementProcessStepDetailedDTO> update(@PathVariable("id") Long id, @RequestBody MeasurementProcessStepUpdateDTO measurementProcessStepUpdateDTO) {
        MeasurementProcessStepDetailedDTO measurementProcessStepDetailedDTO = measurementProcessStepService.update(id, measurementProcessStepUpdateDTO);
        return ResponseEntity.ok(measurementProcessStepDetailedDTO);
    }

}
