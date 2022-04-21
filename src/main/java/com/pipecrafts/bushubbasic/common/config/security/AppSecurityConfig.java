package com.pipecrafts.bushubbasic.common.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    final var userDetailsService = new InMemoryUserDetailsManager();

    final var password = passwordEncoder.encode("12345");
    final var user = User.withUsername("john")
      .password(password)
      .authorities("read")
      .build();
    userDetailsService.createUser(user);

    return userDetailsService;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

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
