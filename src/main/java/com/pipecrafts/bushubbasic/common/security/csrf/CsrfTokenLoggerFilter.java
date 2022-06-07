package com.pipecrafts.bushubbasic.common.security.csrf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class CsrfTokenLoggerFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChainx)
    throws IOException, ServletException {
    final Object o = servletRequest.getAttribute("_csrf");
//    LazyCsrfTokenRepository$SaveOnAccessCsrfToken
    final CsrfToken csrfToken = (CsrfToken) o;

    log.info("CSRF Token: {}", csrfToken.getToken());
    filterChainx.doFilter(servletRequest, servletResponse);

  }
}
