package az.chaypay.shared.profile;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTipRequest {
    private Long userId;
    private Long teamId;
    private Integer ratingValue;
    private String feedback;
    private BigDecimal amount;
}
