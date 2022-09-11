package com.ecom.eshop.service;

import com.ecom.eshop.dao.RoleRepo;
import com.ecom.eshop.entity.RoleEntity;
import com.ecom.eshop.entity.RoleName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<RoleEntity> getAllRoles() {

        return roleRepo.findAll();
    }

    @Override
    public RoleEntity createRole(RoleEntity roleEntity) {
        RoleEntity roleEntityRes = roleRepo.save(roleEntity);
        return roleEntityRes;
    }

}
