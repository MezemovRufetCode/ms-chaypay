package az.chaypay.shared.review;

import lombok.Data;

@Data
public class CreateReviewRequest {
    private final Long userId;
    private final Long teamId;
    private final Long transactionId;
    private final String feedback;
    private final Integer ratingValue;
}
