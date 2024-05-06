package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.UserType;
import com.api.greenway.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public UserType find(Long id) {
        return userTypeRepository.findOneByFinishedAtIsNullAndIdUserType(id);
    }

    public UserType create(UserTypeRegisterDTO userTypeRegisterDTO) {
        return userTypeRepository.save(new UserType(userTypeRegisterDTO));
    }

    public Page<UserTypeDetailedDTO> list(Pageable pagination) {
        return userTypeRepository.findByFinishedAtIsNull(pagination).map(UserTypeDetailedDTO::new);
    }

    public UserTypeDetailedDTO get(Long id) {
        return new UserTypeDetailedDTO(userTypeRepository.findOneByFinishedAtIsNullAndIdUserType(id));
    }

    public void delete(Long id) {
        UserType userType = userTypeRepository.findOneByFinishedAtIsNullAndIdUserType(id);

        userType.disable();

        userTypeRepository.save(userType);
    }

    public UserTypeDetailedDTO update(Long id, UserTypeUpdateDTO userTypeUpdateDTO) {
        UserType userType = userTypeRepository.findOneByFinishedAtIsNullAndIdUserType(id);

        userType.updateInformation(userTypeUpdateDTO);

        userTypeRepository.save(userType);

        return new UserTypeDetailedDTO(userType);
    }

}
