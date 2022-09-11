package com.ecom.eshop.service;

import com.ecom.eshop.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();
    CategoryEntity saveCategory(CategoryEntity categoryEntity);
}
