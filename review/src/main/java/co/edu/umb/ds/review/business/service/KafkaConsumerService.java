package co.edu.umb.ds.review.business.service;

import co.edu.umb.ds.review.persistence.dto.ProductDto;
import co.edu.umb.ds.review.persistence.entities.Product;
import co.edu.umb.ds.review.persistence.repositories.ProductRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class KafkaConsumerService {

  private final String productInfoTopic = "product-info-event";
  private final String groupId= "reviews_group";

  private ProductRepository productRepo;

  KafkaConsumerService(ProductRepository productRepo) {
    this.productRepo = productRepo;
  }

  @KafkaListener(
    topics = productInfoTopic,
    groupId = groupId,
    containerFactory = "productDtoKafkaListenerFactory"
  )
  public void updateProduct(@Valid ProductDto productDto) {
    productRepo.save(Product.builder()
      .id(productDto.getId())
      .name(productDto.getName())
      .build());
  }
}
