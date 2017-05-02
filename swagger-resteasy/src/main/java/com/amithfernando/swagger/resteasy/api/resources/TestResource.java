/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.resteasy.api.resources;

import com.amithfernando.swagger.resteasy.api.exception.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Amith
 */
@Path("/test")
@Api(value = "/test", description = "Operations about user")
@Produces({"application/json"})
public interface TestResource {

    @GET
    @ApiOperation(value = "Test resource",
            response = String.class,
            position = 0)
    Response testResource() throws ApiException;

}
