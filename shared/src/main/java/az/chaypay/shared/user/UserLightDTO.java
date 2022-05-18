package az.chaypay.shared.user;

import lombok.Data;

@Data
public class UserLightDTO {
    private Long id;
    private Long teamId;
    private String phoneNumber;
    private String salt;
    private String verifier;
    private UserRole role;
}
