package az.chaypay.user.service;

import az.chaypay.shared.user.*;

import java.util.List;

public interface UserService {
    UserDTO getById(Long id);

    UserLightDTO getByPhoneNumber(String phoneNumber);

    UserInfoResponse getInfoByQRCode(String qrCode);

    List<UserInfoResponse> getAllByTeamId(Long teamId);

    UserDTO createUser(CreateUserRequest request);

    UserDTO patchUser(Long userId, PatchUserRequest request);
}
