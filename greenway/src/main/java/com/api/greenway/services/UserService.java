package com.api.greenway.services;

import com.api.greenway.controllers.dtos.*;
import com.api.greenway.models.*;
import com.api.greenway.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTypeService userTypeService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserTypeService userTypeService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userTypeService = userTypeService;
        this.passwordEncoder = passwordEncoder;
    }

    public User find(Long id) {
        return userRepository.findOneByFinishedAtIsNullAndIdUser(id);
    }

    public User create(UserRegisterDTO userRegisterDTO) {
        User user = new User(userRegisterDTO);
        UserType userType = userTypeService.find(userRegisterDTO.idUserType());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.password()));
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

        if (userUpdateDTO.password() != null &&
                !passwordEncoder.matches(userUpdateDTO.password(), user.getPassword())) {

            user.setPassword(passwordEncoder.encode(userUpdateDTO.password()));
        }
        userRepository.save(user);

        return new UserDetailedDTO(user);
    }


}
