package az.chaypay.shared.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private Long teamId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String qrCode;
    private String team;
    private String organization;
    private UserRole role;
    private UserStatus status;
    private String salt;
    private String verifier;
}
