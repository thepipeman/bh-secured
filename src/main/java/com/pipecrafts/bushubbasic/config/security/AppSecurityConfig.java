package com.pipecrafts.bushubbasic.config.security;

import com.pipecrafts.bushubbasic.common.management.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AuthenticationProvider authenticationProvider;
  private final AuthEntryPoint authEntryPoint;
  private final UserAuthSuccessHandler userAuthSuccessHandler;
  private final UserAuthFailureHandler userAuthFailureHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .formLogin()
      .successHandler(userAuthSuccessHandler)
      .failureHandler(userAuthFailureHandler)
      .and()
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

    http.csrf().disable();
  }
}
