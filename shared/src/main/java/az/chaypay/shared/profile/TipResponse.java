package az.chaypay.shared.profile;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TipResponse {
    private Long transactionId;
    private Integer ratingValue;
    private String feedback;
    private String belongsTo;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}
