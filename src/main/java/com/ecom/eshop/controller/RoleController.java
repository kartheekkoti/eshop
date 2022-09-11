package com.ecom.eshop.controller;

import com.ecom.eshop.entity.RoleEntity;
import com.ecom.eshop.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRole(@RequestBody RoleEntity roleEntity){
        RoleEntity roleEntity1 = roleService.createRole(roleEntity);
        return new ResponseEntity<>(roleEntity1,HttpStatus.CREATED);
    }
}
