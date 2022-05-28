package com.pipecrafts.bushubbasic.common.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestValidationFilter extends OncePerRequestFilter {

  final static String REQ_ID_HEADER = "REQUEST-ID";

  @Override
  protected void doFilterInternal(
    HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain
  ) throws ServletException, IOException {

    final String requestId = httpRequest.getHeader("Request-Id");

    if (StringUtils.isEmpty(requestId)) {
      httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    filterChain.doFilter(httpRequest, httpResponse);
  }
}
