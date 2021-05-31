package co.edu.umb.ds.review.business.service;

import co.edu.umb.ds.review.persistence.constants.EKafka;
import co.edu.umb.ds.review.persistence.dto.ReviewDto;
import co.edu.umb.ds.review.persistence.dto.ReviewsByProductDto;
import co.edu.umb.ds.review.persistence.entities.Product;
import co.edu.umb.ds.review.persistence.entities.Review;
import co.edu.umb.ds.review.persistence.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KafkaProducerService {

  private KafkaTemplate<String, ReviewsByProductDto> kafkaReviews;

  private ProductRepository productRepo;

  public KafkaProducerService(
    KafkaTemplate<String, ReviewsByProductDto> kafkaReviews,
    ProductRepository productRepo) {
    this.kafkaReviews = kafkaReviews;
    this.productRepo = productRepo;
  }

  public void sendUpdateReviews(Long productId) throws Exception {
    Optional<Product> product = productRepo.findById(productId);
    if (!product.isPresent()) {
      throw new Exception("Producto no encontrado");
    }
    List<Review> reviews = product.get().getReviews();
    float average = 0;
    List<ReviewDto> reviewsDto = new ArrayList<>();
    if (!reviews.isEmpty()) {
      reviewsDto.addAll(ReviewDto.ReviewToReviewDto(reviews));
      int scoreSum = reviewsDto.stream().mapToInt(ReviewDto::getScore).sum();
      average = (float) scoreSum/reviews.size();
      average = (float) (Math.round(average * 100.0) / 100.0);
    }
    var message = ReviewsByProductDto.builder()
      .reviews(reviewsDto)
      .productId(productId)
      .average(average)
      .build();

    var future =
      kafkaReviews.send(EKafka.REVIEW_TOPIC.getMessage(), message);
    future.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error("The message: "+ message.toString() +" cannot was send");
      }

      @Override
      public void onSuccess(SendResult<String, ReviewsByProductDto> stringReviewsByProductDtoSendResult) {
        log.info("The message: "+ message.toString() +" was successful send");
      }
    });
  }
}
