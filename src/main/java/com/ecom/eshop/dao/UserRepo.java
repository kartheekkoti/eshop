package com.ecom.eshop.dao;

import com.ecom.eshop.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findByUserName(String userName);
}
