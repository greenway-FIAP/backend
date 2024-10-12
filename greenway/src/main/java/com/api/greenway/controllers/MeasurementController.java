package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Measurement;
import com.api.greenway.services.MeasurementService;
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
@RequestMapping("/api/measurement")
public class MeasurementController {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid MeasurementRegisterDTO measurementRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Measurement measurement = measurementService.create(measurementRegisterDTO);

        URI uri = uriBuilder.path("/api/measurement/{id}").buildAndExpand(measurement.getIdMeasurement()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<MeasurementDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<MeasurementDetailedDTO> page = measurementService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementDetailedDTO> find(@PathVariable("id") Long id) {
        MeasurementDetailedDTO measurementDetailedDTO = measurementService.get(id);
        return ResponseEntity.ok(measurementDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        measurementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementDetailedDTO> update(@PathVariable("id") Long id, @RequestBody MeasurementUpdateDTO measurementUpdateDTO) {
        MeasurementDetailedDTO measurementDetailedDTO = measurementService.update(id, measurementUpdateDTO);
        return ResponseEntity.ok(measurementDetailedDTO);
    }

}
