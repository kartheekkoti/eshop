package com.ecom.eshop.dao;

import com.ecom.eshop.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<CategoryEntity,String> {
}
