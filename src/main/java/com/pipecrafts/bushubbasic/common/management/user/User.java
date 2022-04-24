package com.pipecrafts.bushubbasic.common.management.user;

import lombok.*;

import javax.persistence.*;
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
  private String username;

  @NonNull
  private String password;

  private String firstName;

  private String middleName;

  private String lastName;

  private LocalDate birthDate;

  @NonNull
  @Enumerated(EnumType.STRING)
  UserRole role;
}