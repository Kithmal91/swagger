/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service.impl;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.dao.CategoryDao;
import com.amithfernando.swagger.springboot.api.v1.model.Category;
import com.amithfernando.swagger.springboot.api.v1.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amithfernando
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> finaAllCategorys() {
        List<Category> categorys = new ArrayList<>();
        Iterable<Category> iterable = categoryDao.findAll();
        for (Category category : iterable) {
            categorys.add(category);
        }
        return categorys;
    }

    @Override
    public List<Category> finaByStatus(GeneralStatus status) {
        List<Category> categorys = categoryDao.findByStatus(status);
        return categorys;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Category save(Category category) {
        Category save = categoryDao.save(category);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Category update(Category category) {
        Category save = categoryDao.save(category);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delet(Category category) {
        category.setStatus(GeneralStatus.DELETED);
        Category save = categoryDao.save(category);
    }

    @Override
    public Category findById(Long id) {
        Category findOne = categoryDao.findOne(id);
        return findOne;
    }

}
