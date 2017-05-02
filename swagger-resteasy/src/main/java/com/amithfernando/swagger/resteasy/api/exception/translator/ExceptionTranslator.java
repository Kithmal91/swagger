/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.resteasy.api.exception.translator;

import com.amithfernando.swagger.resteasy.api.exception.ApiException;
import com.amithfernando.swagger.resteasy.api.models.ApiResponse;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amith
 */
public class ExceptionTranslator {

    private static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(404, "com.amithfernando.jax.rs.template.common.ws.exception.business.RecordNotFoundException");
    }

    public static Exception translate(ApiResponse response) throws ApiException {
        try {
            String exceptionClass = MAP.get(response.getCode());
            if (null != exceptionClass) {
                Constructor<?> constructor = Class.forName(MAP.get(response.getCode())).getConstructor(String.class);
                Object object = constructor.newInstance(new Object[]{response.getMessage()});
                return (Exception) object;
            } else {
                ApiException apiException = new ApiException(response.getCode(), response.getMessage());
                return apiException;
            }
        } catch (Exception e) {
            throw new ApiException(0, e.getMessage());
        }
    }

}
