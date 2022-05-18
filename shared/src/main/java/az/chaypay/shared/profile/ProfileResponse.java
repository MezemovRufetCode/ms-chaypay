package az.chaypay.shared.profile;

import az.chaypay.shared.user.UserRole;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProfileResponse {
    String firstName;
    String lastName;
    UserRole role;
    String team;
    String organization;
    Double ratingValue;
    BigDecimal balance;
    String qrCode;
}
