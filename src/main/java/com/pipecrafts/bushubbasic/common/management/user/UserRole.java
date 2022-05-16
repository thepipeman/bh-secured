package com.pipecrafts.bushubbasic.common.management.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserRole {
  ADMIN,
  CUSTOMER;

  public String getGrantedAuthority() {
    return String.format("ROLE_%s", this.name());
  }
}
