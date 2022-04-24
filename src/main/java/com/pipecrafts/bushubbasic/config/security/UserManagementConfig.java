package com.pipecrafts.bushubbasic.config.security;

import com.pipecrafts.bushubbasic.common.security.memory.InMemoryUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserManagementConfig {

//  @Bean
//  public UserDetailsService userDetailsService(UserUtil userUtil) {
//    return new InMemoryUserDetailsService(userUtil.createInMemoryUsers());
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
