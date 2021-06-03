package co.edu.umb.ds.productinfo.listener;


import co.edu.umb.ds.productinfo.model.ProductInfo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "product-info-event", groupId = "product_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "product-info-event-json", groupId = "product_json",
            containerFactory = "productKafkaListener")
    public void consumeJson(ProductInfo productInfo) {
        System.out.println("Consumed JSON Message: " + productInfo);
    }
}
