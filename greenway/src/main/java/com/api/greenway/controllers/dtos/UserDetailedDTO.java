package com.api.greenway.controllers.dtos;

import com.api.greenway.models.User;

import java.time.LocalDateTime;

public record UserDetailedDTO(

        Long idUser,
        String email,
        String password,

        LocalDateTime createdAt,
        UserTypeDetailedDTO userType

) {
    public UserDetailedDTO(User user) {
        this(user.getIdUser(), user.getEmail(), user.getPassword(), user.getCreatedAt(),
                new UserTypeDetailedDTO(user.getUserType()));
    }

}
