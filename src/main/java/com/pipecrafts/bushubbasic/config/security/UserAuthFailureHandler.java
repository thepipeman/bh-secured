package com.pipecrafts.bushubbasic.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@Component
public class UserAuthFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(
    HttpServletRequest request, HttpServletResponse response, AuthenticationException exception
  ) throws IOException, ServletException {
    log.error("Failed login {}", exception.getMessage());
    response.setHeader("LOGIN_TIMESTAMP", LocalDateTime.now().toString());
  }
}
