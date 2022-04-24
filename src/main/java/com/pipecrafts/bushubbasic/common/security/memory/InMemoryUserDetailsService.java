package com.pipecrafts.bushubbasic.common.security.memory;

import com.pipecrafts.bushubbasic.common.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;

import java.util.List;

@RequiredArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {

  private final List<SecurityUser> users;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.users.stream()
      .filter(u -> u.getUsername().equals(username))
      .findFirst()
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
