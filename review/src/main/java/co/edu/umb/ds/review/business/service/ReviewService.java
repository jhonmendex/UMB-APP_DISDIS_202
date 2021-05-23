package co.edu.umb.ds.review.business.service;

import co.edu.umb.ds.review.persistence.dto.ReviewDto;
import co.edu.umb.ds.review.persistence.entities.Review;
import co.edu.umb.ds.review.persistence.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ReviewService {

  private ReviewRepository reviewRepo;

  private KafkaProducerService kafkaService;

  public ReviewService(ReviewRepository reviewRepo, KafkaProducerService kafkaService)
  {
    this.reviewRepo = reviewRepo;
    this.kafkaService = kafkaService;
  }

  public List<Review> getReviewsByProduct(Long productId) {
    return reviewRepo.getReviewsByProductId(productId);
  }

  public void saveNewReview(ReviewDto reviewDto, Long productId) {
    LocalDate currentDate = LocalDate.now(ZoneId.ofOffset("UTC", ZoneOffset.UTC));
    Review newReview = Review.builder()
      .userName(reviewDto.getUsername())
      .comment(reviewDto.getComment())
      .score(reviewDto.getScore())
      .createdAt(currentDate)
      .modificatedAt(currentDate)
      .productId(productId)
      .build();

    reviewRepo.save(newReview);

    kafkaService.sendUpdateReviews(productId);
  }
}
