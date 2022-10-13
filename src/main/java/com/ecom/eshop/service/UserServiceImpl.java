package com.ecom.eshop.service;

import com.ecom.eshop.dao.RoleRepo;
import com.ecom.eshop.dao.UserRepo;
import com.ecom.eshop.entity.RoleEntity;
import com.ecom.eshop.entity.UserEntity;
import com.ecom.eshop.model.SignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserEntity createUser(SignupRequest signupRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(signupRequest.getName());
        userEntity.setUserName(signupRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userEntity.setEmail(signupRequest.getEmail());
        String[] rolesArray = signupRequest.getRoles().split(",");
        Set<RoleEntity> roleEntities = new LinkedHashSet<>();
        for (String s : rolesArray) {
            roleEntities.add(roleRepo.findByRoleName(s).get());
        }
        userEntity.setRoles(roleEntities);
        UserEntity userEntityResp = userRepo.save(userEntity);
        return userEntityResp;
    }
}
