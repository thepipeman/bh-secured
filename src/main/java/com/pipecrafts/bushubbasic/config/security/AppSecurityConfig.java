package com.pipecrafts.bushubbasic.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

//  private final CustomAuthenticationProvider customAuthenticationProvider;
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.authenticationProvider(customAuthenticationProvider);
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .httpBasic();
    // basic / default spring boot config
    http.authorizeRequests()
      .anyRequest().authenticated();

    // authorizes all request
//    http.authorizeRequests()
//      .anyRequest().permitAll();
  }
}
