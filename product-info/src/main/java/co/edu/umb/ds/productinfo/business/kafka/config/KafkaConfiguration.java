package co.edu.umb.ds.productinfo.business.kafka.config;

import co.edu.umb.ds.productinfo.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {
    @Bean
<<<<<<< HEAD
    public ProducerFactory<String, User> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
=======
    public ProducerFactory<String, KafkaProductInfoDto> producerFactory(){
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
>>>>>>> a63766e440d4c49f686d0e5f408414c74574f236
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

<<<<<<< HEAD

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
=======
    @Bean
    public KafkaTemplate<String, KafkaProductInfoDto> kafkaTemplate(){
>>>>>>> a63766e440d4c49f686d0e5f408414c74574f236
        return new KafkaTemplate<>(producerFactory());
    }
}
