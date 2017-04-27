/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.model.Writer;
import java.util.List;

/**
 *
 * @author amithfernando
 */
public interface WriterService {

    public List<Writer> finaAllWriters();

    public List<Writer> finaByStatus(GeneralStatus status);

    public Writer save(Writer category);

    public Writer update(Writer category);

    public void delet(Writer category);

    public Writer findById(Long id);

}
