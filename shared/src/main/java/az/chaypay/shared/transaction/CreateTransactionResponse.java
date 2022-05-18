package az.chaypay.shared.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTransactionResponse {
    private Long id;
    private String transactionId;
    private String url;
}
