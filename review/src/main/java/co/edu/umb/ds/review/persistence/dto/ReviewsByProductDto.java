package co.edu.umb.ds.review.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsByProductDto {
    private Float average;
    private Long productId;
    private List<ReviewDto> reviews;
}