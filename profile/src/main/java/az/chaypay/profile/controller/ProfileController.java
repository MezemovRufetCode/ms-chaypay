package az.chaypay.profile.controller;

import az.chaypay.profile.service.ProfileService;
import az.chaypay.shared.common.HeaderKeys;
import az.chaypay.shared.profile.TipResponse;
import az.chaypay.shared.profile.CreateTipRequest;
import az.chaypay.shared.profile.CreateTipResponse;
import az.chaypay.shared.profile.ProfileResponse;
import az.chaypay.shared.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/")
public class ProfileController {

    private final ProfileService service;

    @GetMapping("/profile")
    ResponseEntity<ProfileResponse> getUserProfile(
            @RequestHeader(HeaderKeys.HEADER_USER_ID) Long userId,
            @RequestHeader(HeaderKeys.HEADER_TEAM_ID) Long teamId,
            @RequestHeader(HeaderKeys.HEADER_USER_ROLE) UserRole role
    ) {
        return ResponseEntity.ok(service.getProfile(userId, teamId, role));
    }

    @GetMapping("/tip")
    ResponseEntity<List<TipResponse>> getTipList(
            @RequestHeader(HeaderKeys.HEADER_USER_ID) Long userId,
            @RequestHeader(HeaderKeys.HEADER_TEAM_ID) Long teamId,
            @RequestHeader(HeaderKeys.HEADER_USER_ROLE) UserRole role
    ) {
        return ResponseEntity.ok(service.getTipList(userId, teamId, role));
    }



    // TODO: Find a better name for endpoint
    @PostMapping("/public/tip")
    ResponseEntity<CreateTipResponse> createTransaction(
            @RequestBody CreateTipRequest request
    ) {
        return new ResponseEntity<>(service.createTip(request), HttpStatus.CREATED);
    }
}
