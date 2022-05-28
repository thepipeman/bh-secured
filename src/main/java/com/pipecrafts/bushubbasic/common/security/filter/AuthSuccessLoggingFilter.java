package com.pipecrafts.bushubbasic.common.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthSuccessLoggingFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
    HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain
  ) throws ServletException, IOException {

    final String reqId = servletRequest.getHeader(RequestValidationFilter.REQ_ID_HEADER);

    log.info("Request-Id {} successfully authenticated", reqId);
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
