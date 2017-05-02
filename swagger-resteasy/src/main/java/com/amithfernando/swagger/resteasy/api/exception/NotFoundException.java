
package com.amithfernando.swagger.resteasy.api.exception;

public class NotFoundException extends ApiException {

    private int code;

    public NotFoundException(int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
