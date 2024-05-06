package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.UserType;
import com.api.greenway.services.UserTypeService;
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
@RequestMapping("/api/user-type")
public class UserTypeController {

    private final UserTypeService userTypeService;

    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserTypeRegisterDTO userTypeRegisterDTO, UriComponentsBuilder uriBuilder)  {
        UserType userType = userTypeService.create(userTypeRegisterDTO);

        URI uri = uriBuilder.path("/api/user-type/{id}").buildAndExpand(userType.getIdUserType()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<UserTypeDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<UserTypeDetailedDTO> page = userTypeService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDetailedDTO> find(@PathVariable("id") Long id) {
        UserTypeDetailedDTO userTypeDetailedDTO = userTypeService.get(id);
        return ResponseEntity.ok(userTypeDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTypeDetailedDTO> update(@PathVariable("id") Long id, @RequestBody UserTypeUpdateDTO userTypeUpdateDTO) {
        UserTypeDetailedDTO userTypeDetailedDTO = userTypeService.update(id, userTypeUpdateDTO);
        return ResponseEntity.ok(userTypeDetailedDTO);
    }

}
