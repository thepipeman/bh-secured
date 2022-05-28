package com.pipecrafts.bushubbasic.common.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/health")
public class HealthController {

  @GetMapping
  public ResponseEntity<String> readHealth() {
    return ResponseEntity.ok("UP");
  }
}
