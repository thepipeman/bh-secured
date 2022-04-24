package com.pipecrafts.bushubbasic.common.management.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
}