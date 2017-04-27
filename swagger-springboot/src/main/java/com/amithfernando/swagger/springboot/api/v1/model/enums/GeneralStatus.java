/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author amithfernando
 */
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum GeneralStatus {

    ACTIVE, DEACTIVE, DELETED;

}
