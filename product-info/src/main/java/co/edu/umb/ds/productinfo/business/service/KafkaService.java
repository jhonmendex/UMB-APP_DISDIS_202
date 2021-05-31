package co.edu.umb.ds.productinfo.business.service;

import co.edu.umb.ds.productinfo.model.dto.KafkaProductInfoDto;
import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaService {
    @Autowired
    private KafkaTemplate<String, KafkaProductInfoDto> kafkaTemplate;

    private static final String TOPIC = "product-info-event";

    public void saveProduct(ProductInformation productInformation) {

        KafkaProductInfoDto productInfoDto = new KafkaProductInfoDto(productInformation);
        kafkaTemplate.send(TOPIC, productInfoDto);

    }
}
