package com.api.greenway.controllers;


import com.api.greenway.controllers.dtos.BadgeLevelDetailedDTO;
import com.api.greenway.controllers.dtos.BadgeLevelRegisterDTO;
import com.api.greenway.controllers.dtos.BadgeLevelUpdateDTO;
import com.api.greenway.models.BadgeLevel;
import com.api.greenway.services.BadgeLevelService;
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
@RequestMapping("/api/badge-level")
public class BadgeLevelController {

    private final BadgeLevelService badgeLevelService;

    @Autowired
    public BadgeLevelController(BadgeLevelService badgeLevelService) {
        this.badgeLevelService = badgeLevelService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid BadgeLevelRegisterDTO badgeLevelRegisterDTO, UriComponentsBuilder uriBuilder)  {
        BadgeLevel badgeLevel = badgeLevelService.create(badgeLevelRegisterDTO);

        URI uri = uriBuilder.path("/api/badge-level/{id}").buildAndExpand(badgeLevel.getIdBadgeLevel()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<BadgeLevelDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<BadgeLevelDetailedDTO> page = badgeLevelService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BadgeLevelDetailedDTO> find(@PathVariable("id") Long id) {
        BadgeLevelDetailedDTO badgeLevelDetailedDTO = badgeLevelService.get(id);
        return ResponseEntity.ok(badgeLevelDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        badgeLevelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BadgeLevelDetailedDTO> update(@PathVariable("id") Long id, @RequestBody BadgeLevelUpdateDTO badgeLevelUpdateDTO) {
        BadgeLevelDetailedDTO badgeLevelDetailedDTO = badgeLevelService.update(id, badgeLevelUpdateDTO);
        return ResponseEntity.ok(badgeLevelDetailedDTO);
    }

}