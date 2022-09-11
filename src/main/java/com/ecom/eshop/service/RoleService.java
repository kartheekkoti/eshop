package com.ecom.eshop.service;

import com.ecom.eshop.entity.RoleEntity;
import com.ecom.eshop.entity.RoleName;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getAllRoles();
    RoleEntity createRole(RoleEntity roleEntity);
}
