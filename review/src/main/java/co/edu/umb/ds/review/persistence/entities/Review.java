package co.edu.umb.ds.review.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "Review")
@Table(name = "review")
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "review_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "username",
            nullable = false
    )
    private String userName;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDate createdAt;

    @Column(
            name = "modificated_at",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDate modificatedAt;

    @Column(
            name = "comment",
            nullable = false
    )
    private String comment;

    @Column(
            name = "score",
            nullable = false
    )
    private Integer score;

    @Column(
            name = "product_id",
            nullable = false
    )
    private Long productId;
}