/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.amithfernando.swagger.springboot.api.v1.resources;

import com.amithfernando.swagger.springboot.api.v1.exceptions.NotFoundException;
import com.amithfernando.swagger.springboot.api.v1.model.MyApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Amith
 */
public class AbstractResource {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public MyApiResponse exception(NotFoundException e) {
        return new MyApiResponse(MyApiResponse.ERROR, e.getMessage());
    }
}