package com.pipecrafts.bushubbasic.common.management.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<Long> create(@RequestBody @Valid User user) {
    final var id = userService.create(user);
    return new ResponseEntity<>(id, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> readAll() {
    final var users = userService.readAll();
    if (CollectionUtils.isEmpty(users)) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(users);
  }

  @GetMapping("/mydetails")
  public ResponseEntity<User> readMyDetails(Authentication authentication) {
    final String username = authentication.getName();
    final User user = userService.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    return ResponseEntity.ok(user);
  }

  @Async
  @GetMapping("/mydetails/async")
  public ResponseEntity<User> readMyDetailsAsync(Authentication authentication) {
//    SecurityContext context = SecurityContextHolder.getContext();
    String username = authentication.getName();
//    final String username = authentication.getName();
    final User user = userService.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    return ResponseEntity.ok(user);
  }

  @GetMapping("/mydetails/callable")
  public ResponseEntity<User> readMyDetailsFromSelfManagedThread() throws ExecutionException, InterruptedException {
    final Callable<String> callable = () -> {
      SecurityContext context = SecurityContextHolder.getContext();
      return context.getAuthentication().getName();
    };

    final ExecutorService sc = Executors.newCachedThreadPool();
    try {
      final var contextTask = new DelegatingSecurityContextCallable<>(callable);
      final var user = userService.findByUsername(sc.submit(contextTask).get());
      return user.map(ResponseEntity::ok).orElseThrow(() -> new UsernameNotFoundException("username not found"));
    } finally {
      sc.shutdown();
    }
  }


}
