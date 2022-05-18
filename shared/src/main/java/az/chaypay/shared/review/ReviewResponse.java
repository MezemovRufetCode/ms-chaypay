package az.chaypay.shared.review;

import lombok.Data;

@Data
public class ReviewResponse {
    private final Long id;
    private final String feedback;
    private final Integer ratingValue;
    private final Long userId;
    private final Long transactionId;

    public ReviewResponse itself() {
        return this;
    }
}
