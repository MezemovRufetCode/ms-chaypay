package az.chaypay.review.repository.entity;

import az.chaypay.shared.entity.BaseEntity;
import az.chaypay.shared.review.ReviewStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "review", schema = "reviews")
public class Review extends BaseEntity {

    private Long userId;

    private Long teamId;

    private Long transactionId;

    private String feedback;

    @Column(nullable = false)
    private Integer ratingValue;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status = ReviewStatus.ACTIVE;
}