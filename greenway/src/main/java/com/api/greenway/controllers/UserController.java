package com.api.greenway.controllers;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.User;
import com.api.greenway.services.UserService;
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
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserRegisterDTO userRegisterDTO, UriComponentsBuilder uriBuilder)  {
        User user = userService.create(userRegisterDTO);

        URI uri = uriBuilder.path("/api/user/{id}").buildAndExpand(user.getIdUser()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<UserDetailedDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<UserDetailedDTO> page = userService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailedDTO> find(@PathVariable("id") Long id) {
        UserDetailedDTO userDetailedDTO = userService.get(id);
        return ResponseEntity.ok(userDetailedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailedDTO> update(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        UserDetailedDTO userDetailedDTO = userService.update(id, userUpdateDTO);
        return ResponseEntity.ok(userDetailedDTO);
    }

}
