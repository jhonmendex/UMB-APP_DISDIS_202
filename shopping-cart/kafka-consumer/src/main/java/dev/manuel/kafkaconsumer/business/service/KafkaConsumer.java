package dev.manuel.kafkaconsumer.business.service;

import dev.manuel.kafkaconsumer.business.constants.Topic;
import dev.manuel.kafkaconsumer.model.entities.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  @KafkaListener(topics = Topic.LOGIN_TOPIC, groupId = "group_json",
    containerFactory = "userKafkaListenerFactory")
  public void consumeJson(User user) {
    System.out.println("Usuario ingresado: " + user);
  }
}
