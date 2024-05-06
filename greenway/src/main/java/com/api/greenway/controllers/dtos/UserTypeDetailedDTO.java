package com.api.greenway.controllers.dtos;

import com.api.greenway.models.UserType;

public record UserTypeDetailedDTO(
        String title
) {

    public UserTypeDetailedDTO(UserType userType){
        this(userType.getTitle());
    }

}
