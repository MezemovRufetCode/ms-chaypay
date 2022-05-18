package az.chaypay.shared.card;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SimpleCardInfoResponse {
    Long userId;
    BigDecimal balance;
}
