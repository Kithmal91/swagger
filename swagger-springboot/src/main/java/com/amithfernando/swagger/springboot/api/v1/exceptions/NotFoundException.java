/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.amithfernando.swagger.springboot.api.v1.exceptions;

/**
 *
 * @author Amith
 */
public class NotFoundException extends ApiException {
  private int code;
  public NotFoundException (int code, String msg) {
    super(404, msg);
    this.code = code;
  }
}
