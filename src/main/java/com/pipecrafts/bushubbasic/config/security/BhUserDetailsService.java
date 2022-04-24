package com.pipecrafts.bushubbasic.config.security;

import com.pipecrafts.bushubbasic.common.management.user.UserService;
import com.pipecrafts.bushubbasic.common.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

@Primary
@Component
@RequiredArgsConstructor
public class BhUserDetailsService implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final var optionalUser = userService.findByUsername(username);
    return optionalUser.map(SecurityUser::of)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
