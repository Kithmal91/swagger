package com.amithfernando.swagger.springboot.api.v1.exceptions;


import com.amithfernando.swagger.springboot.api.v1.exceptions.ApiException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amith
 */
public class BadRequestException extends ApiException {
  private int code;
  public BadRequestException (int code, String msg) {
    super(code, msg);
    this.code = code;
  }
}
