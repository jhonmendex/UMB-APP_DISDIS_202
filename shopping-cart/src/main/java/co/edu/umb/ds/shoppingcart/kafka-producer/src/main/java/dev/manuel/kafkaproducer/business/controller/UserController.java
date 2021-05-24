package dev.manuel.kafkaproducer.business.controller;

import dev.manuel.kafkaproducer.business.constants.Topic;
import dev.manuel.kafkaproducer.model.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  private final KafkaTemplate<String, User> kafkaTemplate;

  public UserController(KafkaTemplate<String, User> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginRequest(@RequestBody User user){
    kafkaTemplate.send(Topic.LOGIN_TOPIC, user);
    return new ResponseEntity<>("Message sended", HttpStatus.OK);
  }
}
