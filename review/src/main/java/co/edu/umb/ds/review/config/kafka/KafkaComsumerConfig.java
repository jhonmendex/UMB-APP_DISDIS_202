package co.edu.umb.ds.review.config.kafka;

import co.edu.umb.ds.review.persistence.constants.EKafka;
import co.edu.umb.ds.review.persistence.dto.ProductDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaComsumerConfig {

  @Bean
  public ConsumerFactory<String, ProductDto> productDtoConsumerFactory() {
    Map<String, Object> config = new HashMap<>();
    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, EKafka.BOOTSTRAP_SERVER_KAFKA.getMessage());
    config.put(ConsumerConfig.GROUP_ID_CONFIG, EKafka.GROUP_ID.getMessage());
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
      new JsonDeserializer<>(ProductDto.class, false));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, ProductDto> productDtoKafkaListenerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, ProductDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(productDtoConsumerFactory());
    return factory;
  }
}
