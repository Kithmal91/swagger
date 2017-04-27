/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.model.Category;
import java.util.List;

/**
 *
 * @author amithfernando
 */
public interface CategoryService {

    public List<Category> finaAllCategorys();

    public List<Category> finaByStatus(GeneralStatus status);

    public Category save(Category category);

    public Category update(Category category);

    public void delet(Category category);

    public Category findById(Long id);

}
