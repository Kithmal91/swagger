/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.resources;

import com.amithfernando.swagger.springboot.api.v1.model.Category;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.service.CategoryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amithfernando
 */
@RestController
public class CategoryResource {

    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorys")
    public List<Category> getAllCategorys() {
        List<Category> categorys = categoryService.finaAllCategorys();
        return categorys;
    }

    @GetMapping("/categorys/status/{status}")
    public List<Category> getCategorysByStatus(@PathVariable("status") String status) {
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Category> categorys = categoryService.finaByStatus(generalStatus);
        return categorys;
    }

    @GetMapping("/categorys/{id}")
    public Category getCategorysById(@PathVariable Long id) {
        Category categorys = categoryService.findById(id);
        return categorys;
    }

    @PostMapping("/categorys")
    public Category saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return savedCategory;
    }

    @PutMapping("/categorys")
    public Category updateCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.update(category);
        return savedCategory;
    }

    @DeleteMapping("/categorys")
    public void deleteCategory(@RequestBody Category category) {
        categoryService.delet(category);
    }
}
