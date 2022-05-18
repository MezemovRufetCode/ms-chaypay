package az.chaypay.shared.user;

import az.chaypay.shared.review.ReviewResponse;
import lombok.Data;

@Data
public class UserInfoResponse {
    Long userId;
    Long teamId;
    String firstName;
    String lastName;
    String organization;
    String team;

    public UserInfoResponse itself() {
        return this;
    }
}
