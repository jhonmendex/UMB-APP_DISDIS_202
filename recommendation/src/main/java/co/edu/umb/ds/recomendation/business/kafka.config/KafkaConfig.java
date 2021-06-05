package co.edu.umb.ds.recomendation.business.kafka.config;

import co.edu.umb.ds.recomendation.model.dto.KafkaProducInfoDto;
import co.edu.umb.ds.recomendation.model.dto.KafkaReviewDto;
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
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, KafkaProducInfoDto> producInfoConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_product_info_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
            new JsonDeserializer<>(KafkaProducInfoDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaProducInfoDto> producInfoKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaProducInfoDto> factory = new
            ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(producInfoConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, KafkaReviewDto> reviewConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_review_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(KafkaReviewDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaReviewDto> reviewKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaReviewDto> factory = new
                ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(reviewConsumerFactory());
        return factory;
    }

}