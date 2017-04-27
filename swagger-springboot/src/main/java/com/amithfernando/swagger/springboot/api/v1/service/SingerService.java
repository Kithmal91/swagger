/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.model.Singer;
import java.util.List;

/**
 *
 * @author amithfernando
 */
public interface SingerService {

    public List<Singer> finaAllSingers();

    public List<Singer> finaByStatus(GeneralStatus status);

    public Singer save(Singer category);

    public Singer update(Singer category);

    public void delet(Singer category);

    public Singer findById(Long id);

}
