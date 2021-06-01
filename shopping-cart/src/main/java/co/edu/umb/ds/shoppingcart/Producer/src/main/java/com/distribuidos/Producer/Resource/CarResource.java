package com.distribuidos.Producer.Resource;

import com.distribuidos.Producer.Model.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("kafka")
public class CarResource {

    @Autowired
    private KafkaTemplate<String, Carrito> kafkaTemplate;
    private static final String TOPIC="productos añadidos";

    @GetMapping("/publicación/{Carrito}")
    public String post(@PathVariable("message")final String message){

        kafkaTemplate.send(TOPIC, new Carrito() );

        return ("productos mostrados"); 
    }
}
