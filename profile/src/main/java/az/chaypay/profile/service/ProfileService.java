package az.chaypay.profile.service;

import az.chaypay.shared.profile.TipResponse;
import az.chaypay.shared.profile.CreateTipRequest;
import az.chaypay.shared.profile.CreateTipResponse;
import az.chaypay.shared.profile.ProfileResponse;
import az.chaypay.shared.user.UserRole;

import java.util.List;

public interface ProfileService {

    ProfileResponse getProfile(Long userId, Long teamId, UserRole role);

    List<TipResponse> getTipList(Long userId, Long teamId, UserRole role);

    // TODO: Change name
    CreateTipResponse createTip(CreateTipRequest request);
}
