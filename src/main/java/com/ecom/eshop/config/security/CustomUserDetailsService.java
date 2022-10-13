package com.ecom.eshop.config.security;

import com.ecom.eshop.dao.UserRepo;
import com.ecom.eshop.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return CustomUserDetails.create(userEntity);
    }

    public UserDetails loadUserById(String userId) throws UsernameNotFoundException{
        UserEntity userEntity =userRepo.findById(userId).orElseThrow(()->new UsernameNotFoundException("Userr not faound."));
        return CustomUserDetails.create(userEntity);
    }
}
