/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.resteasy.api.exception;

/**
 *
 * @author Amith
 */
public class BusinessException extends ApiException {

    public BusinessException(int code, String msg) {
        super(code, msg);
    }


}
