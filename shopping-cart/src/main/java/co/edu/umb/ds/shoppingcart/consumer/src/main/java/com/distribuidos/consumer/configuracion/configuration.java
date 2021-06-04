package com.distribuidos.consumer.configuracion;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultConsumerFactory;


import java.util.HashMap;
import java.util.Map;

import com.distribuidos.consumer.model.Carrito;

@EnableKafka
@Configuration
public class kafkaconfiguracion{

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
            Map<String, Object> config= new HashMap<>();

            config.put(ConsumerConfig.BOOTSRAP_SERVER_CONFIG, "127.0.0.1:9092");
            config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
            config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultConsumerFactory<String, String>(config,
        new JsonDeserializer<>(Carrito.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Carrito> carritoKafkaListenerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Carrito> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(CarritoConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurreKafkaListenerContainerFactory<String, String> KafkaListenerContainerFactory(){
        
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Shopping_cart> Shopping_cartConsumerFactory(){
        return new DefaultConsumerFactory<String, Shopping_cart>(config);
    }
}