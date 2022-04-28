package com.pipecrafts.bushubbasic.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AuthenticationProvider authenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .authenticationProvider(authenticationProvider)
      .httpBasic()
      .and().authorizeRequests()
      .anyRequest().authenticated();
//    // basic / default spring boot config
//    http.authorizeRequests()
//      .anyRequest().authenticated();

    http.csrf().disable();
  }
}
