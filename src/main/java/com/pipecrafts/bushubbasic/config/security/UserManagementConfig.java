package com.pipecrafts.bushubbasic.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

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

}
