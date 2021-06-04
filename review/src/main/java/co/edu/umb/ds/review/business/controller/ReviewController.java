package co.edu.umb.ds.review.business.controller;

import co.edu.umb.ds.review.business.service.ReviewService;
import co.edu.umb.ds.review.persistence.dto.ReviewDto;
import co.edu.umb.ds.review.persistence.entities.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

  private ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/{productId}")
  public ResponseEntity<List<ReviewDto>> getReviewsByProduct(@PathVariable("productId") Long productId) {
    return new ResponseEntity(reviewService.getReviewsByProduct(productId), HttpStatus.OK);
  }

  @PostMapping("/{productId}")
  public ResponseEntity createReview(@Valid @RequestBody ReviewDto reviewDto,
                                     @PathVariable Long productId) throws Exception {
    reviewService.saveNewReview(reviewDto, productId);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @PutMapping("/{reviewId}")
  public ResponseEntity updateReview(@Valid @RequestBody ReviewDto reviewDto,
                                     @PathVariable Long reviewId) throws Exception {
    reviewService.updateReview(reviewDto, reviewId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{reviewId}")
  public ResponseEntity deleteReview(@PathVariable Long reviewId) throws Exception {
    reviewService.deleteReview(reviewId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

}