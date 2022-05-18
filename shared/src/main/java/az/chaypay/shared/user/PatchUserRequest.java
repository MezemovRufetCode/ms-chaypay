package az.chaypay.shared.user;

import lombok.Data;

@Data
public class PatchUserRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String salt;
    private String verifier;
    private UserStatus status;
}