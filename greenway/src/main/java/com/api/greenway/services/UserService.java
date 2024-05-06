package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.*;
import com.api.greenway.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTypeService userTypeService;

    @Autowired
    public UserService(UserRepository userRepository, UserTypeService userTypeService) {
        this.userRepository = userRepository;
        this.userTypeService = userTypeService;
    }

    public User create(UserRegisterDTO userRegisterDTO) {
        User user = new User(userRegisterDTO);

        UserType userType = userTypeService.find(userRegisterDTO.idUserType());

        user.setUserType(userType);

        return userRepository.save(user);
    }

    public Page<UserDetailedDTO> list(Pageable pagination) {
        return userRepository.findByFinishedAtIsNull(pagination).map(UserDetailedDTO::new);
    }

    public UserDetailedDTO get(Long id) {
        return new UserDetailedDTO(userRepository.findOneByFinishedAtIsNullAndIdUser(id));
    }

    public void delete(Long id) {
        User user = userRepository.findOneByFinishedAtIsNullAndIdUser(id);

        user.disable();

        userRepository.save(user);
    }

    public UserDetailedDTO update(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findOneByFinishedAtIsNullAndIdUser(id);

        user.updateInformation(userUpdateDTO);

        userRepository.save(user);

        return new UserDetailedDTO(user);
    }


}
