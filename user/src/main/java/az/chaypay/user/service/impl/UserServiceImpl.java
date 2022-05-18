package az.chaypay.user.service.impl;

import az.chaypay.shared.user.*;
import az.chaypay.shared.util.NanoIdUtils;
import az.chaypay.user.service.UserService;
import az.chaypay.shared.user.exception.UserNotFoundException;
import az.chaypay.user.mapper.UserMapper;
import az.chaypay.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserMapper mapper;

    @Override
    public UserDTO getById(Long id) {
        var user = repo.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return mapper.toUserDTO(user);
    }

    @Override
    public UserLightDTO getByPhoneNumber(String phoneNumber) {
        var user = repo.findByPhoneNumber(phoneNumber)
                .orElseThrow(UserNotFoundException::new);
        return mapper.toUserLightDTO(user);
    }

    @Override
    public UserInfoResponse getInfoByQRCode(String qrCode) {
        var user = repo.findByQrCode(qrCode)
                .orElseThrow(UserNotFoundException::new);
        return mapper.toUserInfoResponse(user);
    }

    @Override
    public List<UserInfoResponse> getAllByTeamId(Long teamId) {
        var users = repo.getAllByTeamId(teamId);
        return users.stream()
                .map(mapper::toUserInfoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(CreateUserRequest request) {
        var entity = repo.save(mapper.toUserEntity(request));
        return mapper.toUserDTO(entity);
    }

    @Override
    public UserDTO patchUser(Long userId, PatchUserRequest request) {
        return null;
    }
}
