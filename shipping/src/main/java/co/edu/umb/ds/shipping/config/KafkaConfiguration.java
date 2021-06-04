package co.edu.umb.ds.shipping.config;

import co.edu.umb.ds.shipping.persistence.entity.publics.OrderHistory;
import co.edu.umb.ds.shipping.persistence.entity.publics.Shipping;
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
public class KafkaConfiguration {

  @Bean
  public ConsumerFactory<String, Shipping> orderHistoryConsumerFactory() {
    Map<String, Object> config = new HashMap<>();
    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    config.put(ConsumerConfig.GROUP_ID_CONFIG, "order_from_shipping");
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
      new JsonDeserializer<>(Shipping.class, false));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Shipping> orderHistoryKafkaListenerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Shipping> factory = new ConcurrentKafkaListenerContainerFactory<String, Shipping>();
    factory.setConsumerFactory(orderHistoryConsumerFactory());
    return factory;
  }
}
