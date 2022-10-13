package com.ecom.eshop.service;

import com.ecom.eshop.entity.UserEntity;
import com.ecom.eshop.model.SignupRequest;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity createUser(SignupRequest signupRequest);
}
