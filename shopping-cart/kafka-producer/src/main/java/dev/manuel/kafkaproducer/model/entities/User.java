package dev.manuel.kafkaproducer.model.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  private Integer id;
  private String name;
  private String email;
  private String password;

}
