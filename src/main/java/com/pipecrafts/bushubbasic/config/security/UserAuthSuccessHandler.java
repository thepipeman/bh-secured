package com.pipecrafts.bushubbasic.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@Component
class UserAuthSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(
    HttpServletRequest request,
    HttpServletResponse response,
    Authentication authentication
  ) throws IOException, ServletException {
    log.info("Successful login for {}", authentication.getName());
    response.setHeader("LOGIN_TIMESTAMP", LocalDateTime.now().toString());
  }
}
