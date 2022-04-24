package com.pipecrafts.bushubbasic.common.management.user;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public Long create(User user) {
    final var encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    final var userCreated = userRepository.save(user);
    log.trace("User created [id=<{}>]", userCreated.getId());
    return userCreated.getId();
  }

  public Optional<User> findByUsername(String username) {
    return Optional.ofNullable(userRepository.findByUsername(username));
  }

  public List<User> readAll() {
    return Lists.newArrayList(userRepository.findAll());
  }

}
