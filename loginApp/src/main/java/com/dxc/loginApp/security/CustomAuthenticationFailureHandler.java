/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 7
 */

package com.dxc.loginApp.security;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, 
            HttpServletResponse httpServletResponse, AuthenticationException e) 
            throws IOException {
        httpServletResponse.setStatus(HttpStatus.UNATHORIZED.value());
        
        String jsonPayload = "{\"message\" : \"%s\", \"timestamp\" : \"%s\"}";
        httpServletResponse.getOutputStream().println(
                String.format(jsonPayload, e.getMessage, Calendar.getInstance().getTime()));
    }
}