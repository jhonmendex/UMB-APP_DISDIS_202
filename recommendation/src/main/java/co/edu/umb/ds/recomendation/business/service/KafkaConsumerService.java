package co.edu.umb.ds.recomendation.business.service;

import co.edu.umb.ds.recomendation.model.dto.KafkaProducInfoDto;
import co.edu.umb.ds.recomendation.model.dto.KafkaReviewDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumerService {

    private ProductServiceImpl productServiceImpl;

    @KafkaListener(
        topics = "product-info-event",
        groupId = "group_product_info_json",
        containerFactory = "producInfoKafkaListenerFactory")
    public void consumeProductInfo(KafkaProducInfoDto producInfoDto){

        productServiceImpl.updateProductInfo(producInfoDto);
    }

    @KafkaListener(
        topics = "review-by-product-event",
        groupId = "group_review_json",
        containerFactory = "reviewKafkaListenerFactory")
    public void consumeReview(KafkaReviewDto reviewDto){

        productServiceImpl.updateProductReview(reviewDto);
    }
}