package co.edu.umb.ds.review.persistence.dto;

import co.edu.umb.ds.review.persistence.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    public ReviewDto(Review review) {
        this.id = review.getId();
        this.username = review.getUserName();
        this.comment = review.getComment();
        this.createdAt = review.getCreatedAt();
        this.modificatedAt = review.getModificatedAt();
        this.score = review.getScore();
    }

    public static List<ReviewDto> ReviewToReviewDto(List<Review> reviews){
        List<ReviewDto> reviewsDto = new ArrayList<>();
        for (Review review : reviews) {
            reviewsDto.add(new ReviewDto(review));
        }
        return reviewsDto;
    }

    @Null
    private Long id;

    @NotBlank(message = "the username mustn't be empty")
    private String username;

    @NotBlank(message = "the comment mustn't be empty")
    private String comment;

    @Null
    private LocalDate createdAt;

    @Null
    private LocalDate modificatedAt;

    @Min(message = "The score must be greater than 0",
            value = 0)
    @Max(message = "The score must be smaller than 5",
            value = 5)
    private Integer score;

}