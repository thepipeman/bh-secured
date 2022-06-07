package com.pipecrafts.bushubbasic.config.security;

import com.pipecrafts.bushubbasic.common.management.user.UserRole;
import com.pipecrafts.bushubbasic.common.security.csrf.CsrfTokenLoggerFilter;
import com.pipecrafts.bushubbasic.common.security.filter.AuthSuccessLoggingFilter;
import com.pipecrafts.bushubbasic.common.security.filter.RequestValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AuthenticationProvider authenticationProvider;
  private final AuthEntryPoint authEntryPoint;
    private final RequestValidationFilter requestValidationFilter;
  private final AuthSuccessLoggingFilter authSuccessLoggingFilter;
//  private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;
  private final CsrfTokenLoggerFilter csrfTokenLoggerFilter;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .addFilterBefore(requestValidationFilter, BasicAuthenticationFilter.class)
      .addFilterAfter(authSuccessLoggingFilter, BasicAuthenticationFilter.class)
      .addFilterAfter(csrfTokenLoggerFilter, CsrfFilter.class)
      .authenticationProvider(authenticationProvider)
      .httpBasic()
      .authenticationEntryPoint(authEntryPoint)
      .and()
      .authorizeRequests()
      .antMatchers("/buses")
      .hasAnyRole(UserRole.ADMIN.name(), UserRole.CUSTOMER.name())
      .antMatchers("/users")
      .hasAnyRole(UserRole.ADMIN.name())
      .anyRequest().authenticated();

//    // basic / default spring boot config
//    http.authorizeRequests()
//      .anyRequest().authenticated();

//    http.csrf().disable();
  }
}
