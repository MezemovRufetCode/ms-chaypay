package az.chaypay.shared.profile;

import lombok.Data;

@Data
public class CreateTipResponse {
    private final String transactionId;
    private final String url;
}
