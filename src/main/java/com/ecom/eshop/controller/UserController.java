package com.ecom.eshop.controller;

import com.ecom.eshop.model.SignupRequest;
import com.ecom.eshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest){
        return new ResponseEntity<>(userService.createUser(signupRequest),HttpStatus.CREATED);
    }
}
