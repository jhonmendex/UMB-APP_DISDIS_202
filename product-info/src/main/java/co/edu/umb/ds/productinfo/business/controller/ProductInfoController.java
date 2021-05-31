package co.edu.umb.ds.productinfo.business.controller;

import co.edu.umb.ds.productinfo.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ProductInfoController {
    @Autowired
    private KafkaTemplate<String, ProductInfo> kafkaTemplate;

    private static final String TOPIC = "product-info-event";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new ProductInfo(name, "Technology", 12000L));

        return "Published successfully";
    }
}
