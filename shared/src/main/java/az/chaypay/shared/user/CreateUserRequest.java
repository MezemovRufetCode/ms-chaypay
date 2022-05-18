package az.chaypay.shared.user;

import lombok.Data;

@Data
public class CreateUserRequest {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private UserRole role;
        private String team;
        private String organization;
        private String salt;
        private String verifier;
}
