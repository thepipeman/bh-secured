package com.pipecrafts.bushubbasic.common.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestValidationFilter implements Filter {

  private final static String REQ_ID_HEADER = "REQUEST-ID";

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {

    final HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

    final String requestId = httpRequest.getHeader("Request-Id");

    if (StringUtils.isEmpty(requestId)) {
      httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
