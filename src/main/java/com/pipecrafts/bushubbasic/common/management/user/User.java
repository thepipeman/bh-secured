package com.pipecrafts.bushubbasic.common.management.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(schema = "mng", name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String username;

  @NotNull
  private String password;

  @NotNull
  private String firstName;

  @NotNull
  private String middleName;

  @NotNull
  private String lastName;

  @NotNull
  private LocalDate birthDate;

//  @NotNull
//  private Set<GrantedAuthority> authorities;
}