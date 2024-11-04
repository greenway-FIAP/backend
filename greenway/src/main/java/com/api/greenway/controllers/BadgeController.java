package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.Badge;
import com.api.greenway.services.BadgeService;
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
@RequestMapping("/api/badge")
public class BadgeController {

    private final BadgeService badgeService;

    @Autowired
    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid BadgeRegisterDTO badgeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        Badge badge = badgeService.create(badgeRegisterDTO);

        URI uri = uriBuilder.path("/api/badge/{id}").buildAndExpand(badge.getIdBadge()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<BadgeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<BadgeDetailedDTO> page = badgeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BadgeDetailedDTO> find(@PathVariable("id") Long id) {
        BadgeDetailedDTO badgeDetailedDTO = badgeService.get(id);
        return ResponseEntity.ok(badgeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        badgeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BadgeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody BadgeUpdateDTO badgeUpdateDTO) {
        BadgeDetailedDTO badgeDetailedDTO = badgeService.update(id, badgeUpdateDTO);
        return ResponseEntity.ok(badgeDetailedDTO);
    }

}
