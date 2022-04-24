package com.pipecrafts.bushubbasic.common.management.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(schema = "mng", name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @NotNull
  private String username;

  @NonNull
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

  @NotNull
  @NonNull
  @Enumerated(EnumType.STRING)
  UserRole role;
}