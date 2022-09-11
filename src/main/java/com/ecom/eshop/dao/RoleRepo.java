package com.ecom.eshop.dao;

import com.ecom.eshop.entity.RoleEntity;
import com.ecom.eshop.entity.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepo extends MongoRepository<RoleEntity,String> {
    Optional<RoleEntity> findByRoleName(String roleName);
}
