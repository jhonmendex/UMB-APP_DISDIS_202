package com.distribuidos.consumer.listener;

import org.springframework.stereotype.Service;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import com.distribuidos.consumer.model.Carrito;



@Service
public class Consumer{

    @KafkaListener(topics= "Lista_productos", group="group_id")
    public void consume(String message){
        System.out.println("Consumed message:"+ message);
    }
 

    @KafkaListener(topics = "Lista_productos_json", group="group_json",
    containerFactory = "carritotKafkaListenerFactory")
    public void consumeJson(Carrito carrito){
        System.out.println("Consumed JSON message:"+ carrito);
    }
}