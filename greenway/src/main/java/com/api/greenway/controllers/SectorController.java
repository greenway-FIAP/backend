package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.SectorDetailedDTO;
import com.api.greenway.controllers.dtos.SectorRegisterDTO;
import com.api.greenway.controllers.dtos.SectorUpdateDTO;
import com.api.greenway.models.Sector;
import com.api.greenway.services.SectorService;
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
@RequestMapping("/api/sector")
public class SectorController {
    private final SectorService sectorService;

    @Autowired
    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SectorRegisterDTO sectorRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Sector sector = sectorService.create(sectorRegisterDTO);

        URI uri = uriBuilder.path("/api/sector/{id}").buildAndExpand(sector.getIdSector()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<SectorDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<SectorDetailedDTO> page = sectorService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDetailedDTO> find(@PathVariable("id") Long id) {
        SectorDetailedDTO sectorDetailedDTO = sectorService.get(id);
        return ResponseEntity.ok(sectorDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        sectorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDetailedDTO> update(@PathVariable("id") Long id, @RequestBody SectorUpdateDTO sectorUpdateDTO) {
        SectorDetailedDTO sectorDetailedDTO = sectorService.update(id, sectorUpdateDTO);
        return ResponseEntity.ok(sectorDetailedDTO);
    }
}
