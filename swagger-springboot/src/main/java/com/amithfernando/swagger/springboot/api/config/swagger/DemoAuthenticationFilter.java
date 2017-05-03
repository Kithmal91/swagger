/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.config.swagger;

import com.amithfernando.swagger.springboot.api.v1.exceptions.UnAuthorizedException;
import com.amithfernando.swagger.springboot.api.v1.model.MyApiResponse;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Amith
 */
@Configuration
public class DemoAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        String uri = request.getRequestURI();
        String method = request.getMethod();
        if (!isSwaggerResource(uri) && isSecuredHttpMethod(method)) {
            try {
                String xAuth = request.getHeader("mykey");
                if (null != xAuth && xAuth.equals("123")) {
                    // validate the value in xAuth
                    filterChain.doFilter(request, response);
                } else {
                    ((HttpServletResponse) response).sendError(HttpStatus.UNAUTHORIZED.value(), "Un authorized!");
                }
            } catch (NullPointerException e) {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean isSwaggerResource(String uri) {
        if (uri.contains("/v2/api-docs")
                || uri.contains("swagger-ui.html")
                || uri.contains("/webjars/")
                || uri.contains("/favicon.ico")
                || uri.contains("/swagger-resources")) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isSecuredHttpMethod(String method){
        if(method.equals("POST")){
            return true;
        }else{
            return false;
        }
    }

}
