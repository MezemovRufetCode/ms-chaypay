package az.chaypay.shared.transaction;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TransactionResponse {
    Long id;
    Long userId;
    BigDecimal amount;
    LocalDateTime createdAt;
}
