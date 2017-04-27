/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.model;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author amithfernando
 */
@MappedSuperclass
public class AbstractModel {
    
    @Enumerated(EnumType.STRING)
    private GeneralStatus status;

    public GeneralStatus getStatus() {
        return status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }
    
    
    
}
