package com.ecom.eshop.controller;

import com.ecom.eshop.entity.CategoryEntity;
import com.ecom.eshop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> createCategory(@RequestBody CategoryEntity categoryEntity){
        CategoryEntity categoryEntityResp = categoryService.saveCategory(categoryEntity);
        return new ResponseEntity<>(categoryEntityResp,HttpStatus.CREATED);
    }
}
