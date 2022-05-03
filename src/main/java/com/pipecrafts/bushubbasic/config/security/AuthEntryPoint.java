package com.pipecrafts.bushubbasic.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
    throws IOException, ServletException {
    response
      .addHeader("message", "WTF from AuthEntryPoint");
    response
      .sendError(HttpStatus.UNAUTHORIZED.value());
  }
}
