package co.edu.umb.ds.review.config.kafka;

import co.edu.umb.ds.review.persistence.constants.EKafka;
import co.edu.umb.ds.review.persistence.dto.ReviewsByProductDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfig {

  @Bean
  public ProducerFactory<String, ReviewsByProductDto> reviewsProducerFactory(){
    Map<String, Object> config = new HashMap<>();

    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, EKafka.BOOTSTRAP_SERVER_KAFKA.getMessage());
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    return new DefaultKafkaProducerFactory<>(config);
  }

  @Bean
  public KafkaTemplate<String, ReviewsByProductDto> kafkaTemplate(){
    return new KafkaTemplate<String, ReviewsByProductDto>(reviewsProducerFactory());
  }
}
