package co.edu.umb.ds.review.business.service;

import co.edu.umb.ds.review.persistence.dto.ReviewDto;
import co.edu.umb.ds.review.persistence.entities.Product;
import co.edu.umb.ds.review.persistence.entities.Review;
import co.edu.umb.ds.review.persistence.repositories.ProductRepository;
import co.edu.umb.ds.review.persistence.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

  private ReviewRepository reviewRepo;

  private KafkaProducerService kafkaService;

  private ProductRepository productRepo;

  public ReviewService(ReviewRepository reviewRepo,ProductRepository productRepo , KafkaProducerService kafkaService)
  {
    this.reviewRepo = reviewRepo;
    this.kafkaService = kafkaService;
    this.productRepo = productRepo;
  }

  public List<ReviewDto> getReviewsByProduct(Long productId) {
    Optional<Product> product = productRepo.findById(productId);
    if (!product.isPresent()){

    }
    return ReviewDto.ReviewToReviewDto(product.get().getReviews());
  }

  public void saveNewReview(ReviewDto reviewDto, Long productId) throws Exception {
    LocalDate currentDate = LocalDate.now(ZoneId.ofOffset("UTC", ZoneOffset.UTC));
    Review newReview = Review.builder()
      .userName(reviewDto.getUsername())
      .comment(reviewDto.getComment())
      .score(reviewDto.getScore())
      .createdAt(currentDate)
      .modificatedAt(currentDate)
      .product(Product.builder().id(productId).build())
      .build();

    reviewRepo.save(newReview);

    kafkaService.sendUpdateReviews(productId);
  }

  public void updateReview(ReviewDto reviewDto, Long reviewId) throws Exception {
    Optional<Review> review = reviewRepo.findById(reviewId);
    if(!review.isPresent()) {
     throw new Exception("The review with id "+reviewId+" doesn't exist");
    }
    Review currentReview = review.get();
    currentReview.setModificatedAt(LocalDate.now(ZoneId.ofOffset("UTC", ZoneOffset.UTC)));
    if (reviewDto.getComment() != null) {
      currentReview.setComment(reviewDto.getComment());
    }
    if (reviewDto.getScore() != null) {
      currentReview.setScore(reviewDto.getScore());
    }
    reviewRepo.save(currentReview);
    kafkaService.sendUpdateReviews(currentReview.getProduct().getId());
  }

  public void deleteReview(Long reviewId) throws Exception {
    Optional<Review> review = reviewRepo.findById(reviewId);
    if(!review.isPresent()) {
      throw new Exception("The review with id "+reviewId+" doesn't exist");
    }
    reviewRepo.delete(review.get());
    kafkaService.sendUpdateReviews(review.get().getProduct().getId());
  }
}
