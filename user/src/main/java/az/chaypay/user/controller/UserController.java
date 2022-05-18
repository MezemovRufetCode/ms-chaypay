package az.chaypay.user.controller;

import az.chaypay.shared.common.ParamKeys;
import az.chaypay.shared.user.UserInfoResponse;
import az.chaypay.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private final UserService service;

    @GetMapping("/public/user")
    ResponseEntity<UserInfoResponse> getUserInfo(
            @RequestParam(ParamKeys.PARAM_QR_CODE) String qrCode
    ) {
        return ResponseEntity.ok(service.getInfoByQRCode(qrCode));
    }
}
