package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.ImprovementMeasurement;
import com.api.greenway.services.ImprovementMeasurementService;
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
@RequestMapping("/api/improvement-measurement")
public class ImprovementMeasurementController {

    private final ImprovementMeasurementService improvementMeasurementService;

    @Autowired
    public ImprovementMeasurementController(ImprovementMeasurementService improvementMeasurementService) {
        this.improvementMeasurementService = improvementMeasurementService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ImprovementMeasurementRegisterDTO improvementMeasurementRegisterDTO, UriComponentsBuilder uriBuilder)  {
        ImprovementMeasurement improvementMeasurement = improvementMeasurementService.create(improvementMeasurementRegisterDTO);

        URI uri = uriBuilder.path("/api/improvement-measurement/{id}").buildAndExpand(improvementMeasurement.getIdImprovementMeasurement()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ImprovementMeasurementDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Pageable pageable = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
        Page<ImprovementMeasurementDetailedDTO> page = improvementMeasurementService.list(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImprovementMeasurementDetailedDTO> find(@PathVariable("id") Long id) {
        ImprovementMeasurementDetailedDTO improvementMeasurementDetailedDTO = improvementMeasurementService.get(id);
        return ResponseEntity.ok(improvementMeasurementDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        improvementMeasurementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImprovementMeasurementDetailedDTO> update(@PathVariable("id") Long id, @RequestBody ImprovementMeasurementUpdateDTO improvementMeasurementUpdateDTO) {
        ImprovementMeasurementDetailedDTO improvementMeasurementDetailedDTO = improvementMeasurementService.update(id, improvementMeasurementUpdateDTO);
        return ResponseEntity.ok(improvementMeasurementDetailedDTO);
    }

}
