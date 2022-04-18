package com.pipecrafts.bushubbasic.common.bus;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(schema = "vh", name = "bus")
public class Bus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Enumerated(EnumType.STRING)
  private BusType type;

  @NotNull
  private String plateNumber;

  @NotNull
  private String number;
}
