package com.pipecrafts.bushubbasic.common.management.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;
  private String firstName;
  private String middleName;
  private String lastName;
  private LocalDate birthDate;
}
