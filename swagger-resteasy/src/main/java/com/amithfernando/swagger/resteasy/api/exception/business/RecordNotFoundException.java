/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.amithfernando.swagger.resteasy.api.exception.business;

import com.amithfernando.swagger.resteasy.api.exception.BusinessException;


/**
 *
 * @author Amith
 */
public class RecordNotFoundException extends BusinessException{

    public RecordNotFoundException(String msg) {
        super(404, msg);
    }

}
