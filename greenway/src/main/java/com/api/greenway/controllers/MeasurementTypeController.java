package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.MeasurementType;
import com.api.greenway.services.MeasurementTypeService;
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
@RequestMapping("/api/measurement-type")
public class MeasurementTypeController {

    private final MeasurementTypeService measurementTypeService;

    @Autowired
    public MeasurementTypeController(MeasurementTypeService measurementTypeService) {
        this.measurementTypeService = measurementTypeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid MeasurementTypeRegisterDTO measurementTypeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        MeasurementType measurementType = measurementTypeService.create(measurementTypeRegisterDTO);

        URI uri = uriBuilder.path("/api/measurement-type/{id}").buildAndExpand(measurementType.getIdMeasurementType()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<MeasurementTypeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<MeasurementTypeDetailedDTO> page = measurementTypeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementTypeDetailedDTO> find(@PathVariable("id") Long id) {
        MeasurementTypeDetailedDTO measurementTypeDetailedDTO = measurementTypeService.get(id);
        return ResponseEntity.ok(measurementTypeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        measurementTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementTypeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody MeasurementTypeUpdateDTO measurementTypeUpdateDTO) {
        MeasurementTypeDetailedDTO measurementTypeDetailedDTO = measurementTypeService.update(id, measurementTypeUpdateDTO);
        return ResponseEntity.ok(measurementTypeDetailedDTO);
    }

}
