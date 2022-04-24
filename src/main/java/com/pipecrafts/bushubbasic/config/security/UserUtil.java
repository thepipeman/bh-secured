package com.pipecrafts.bushubbasic.config.security;

import com.google.common.collect.Lists;
import com.pipecrafts.bushubbasic.common.management.user.User;
import com.pipecrafts.bushubbasic.common.management.user.UserRole;
import com.pipecrafts.bushubbasic.common.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public final class UserUtil {

  private final PasswordEncoder passwordEncoder;

  public List<SecurityUser> createInMemoryUsers() {
    final var c1 = createUser("janedoe", UserRole.CUSTOMER);
    final var c2 = createUser("johnfoo", UserRole.CUSTOMER);
    final var c3 = createUser("admin", UserRole.ADMIN);

    return Lists.newArrayList(c1, c2, c3);
  }

  private SecurityUser createUser(String username, UserRole role) {
    final var password = UUID.randomUUID().toString().substring(0, 8);
    log.debug("Password for user {}: {}", username, password);
    final User user = User.builder()
      .username(username)
      .password(passwordEncoder.encode(password))
      .role(role)
      .build();

    return SecurityUser.of(user);
  }
}
