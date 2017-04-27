/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import java.util.List;

/**
 *
 * @author amithfernando
 */
public interface ComposerService {

    public List<Composer> finaAllComposers();

    public List<Composer> finaByStatus(GeneralStatus status);

    public Composer save(Composer category);

    public Composer update(Composer category);

    public void delet(Composer category);

    public Composer findById(Long id);

}
