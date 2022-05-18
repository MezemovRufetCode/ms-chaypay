package az.chaypay.shared.transaction;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactionRequest {
    private Long userId;
    private Long teamId;
    private BigDecimal amount;
}
