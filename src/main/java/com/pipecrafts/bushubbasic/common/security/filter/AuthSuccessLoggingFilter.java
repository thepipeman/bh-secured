package com.pipecrafts.bushubbasic.common.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class AuthSuccessLoggingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {
    final HttpServletRequest httpRequet = (HttpServletRequest) servletRequest;
    final String reqId = httpRequet.getHeader(RequestValidationFilter.REQ_ID_HEADER);

    log.info("Request-Id {} successfully authenticated", reqId);
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
