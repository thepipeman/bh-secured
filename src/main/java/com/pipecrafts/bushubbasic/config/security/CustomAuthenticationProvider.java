package com.pipecrafts.bushubbasic.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Can be used to manually implement authentication.
 * <p>
 * e.g. Retrieving username and password using encryption
 */
//@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

//  private final PasswordEncoder passwordEncoder;
//  private final UserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    final var username = authentication.getName();
    final var password = String.valueOf(authentication.getCredentials());

//    final var user = userDetailsService.loadUserByUsername(username);
//
//    if (!passwordEncoder.matches(password, user.getPassword())) {
//      throw new AuthenticationCredentialsNotFoundException("Error in authentication");
//    }
//    return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());

    // sample without using the services
    if ("jane".equals(username) && "67890".equals(password)) {
      return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
    } else {

      throw new AuthenticationCredentialsNotFoundException("Error in authentication");
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
