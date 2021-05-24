package dev.manuel.kafkaconsumer.model.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Shopinng_cart {

  private Integer id;
  private String name;
  private String email;
  private String password;

}
