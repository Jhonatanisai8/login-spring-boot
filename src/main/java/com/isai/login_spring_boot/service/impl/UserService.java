package com.isai.login_spring_boot.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isai.login_spring_boot.dto.UserRequest;
import com.isai.login_spring_boot.models.Rol;
import com.isai.login_spring_boot.models.User;
import com.isai.login_spring_boot.repository.UserRepository;
import com.isai.login_spring_boot.service.CrudService;

@Service
public class UserService
        implements CrudService<User, UserRequest> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRequest entity) {
        return userRepository.save(convertToEntity(entity));
    }

    private User convertToEntity(UserRequest userRequest) {
        return User.builder()
                .userId(userRequest.getUserId())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .roles(Arrays.asList(new Rol("USER")))
                .build();
    }
}
