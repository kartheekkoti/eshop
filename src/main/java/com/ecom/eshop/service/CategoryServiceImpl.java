package com.ecom.eshop.service;

import com.ecom.eshop.dao.CategoryRepo;
import com.ecom.eshop.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        List<CategoryEntity> catList = categoryRepo.findAll();
        return catList;
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        CategoryEntity categoryEntityResp = categoryRepo.save(categoryEntity);
        return categoryEntityResp;
    }
}
