package co.edu.umb.ds.recomendation.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KafkaReviewDto {

    private Long productId;
    private float average;
}
