package az.chaypay.user.controller;

import az.chaypay.shared.common.ParamKeys;
import az.chaypay.shared.user.PatchUserRequest;
import az.chaypay.shared.user.UserLightDTO;
import az.chaypay.user.service.UserService;
import az.chaypay.shared.user.CreateUserRequest;
import az.chaypay.shared.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/internal/user")
public class InternalUserController {

    private final UserService service;

    //TODO: Delete if not needed
    @GetMapping
    ResponseEntity<UserDTO> getUserById(@RequestParam(ParamKeys.PARAM_USER_ID) Long userId) {
        return ResponseEntity.ok(service.getById(userId));
    }

    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest request) {
        return new ResponseEntity<>(service.createUser(request), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody PatchUserRequest request) {
        return new ResponseEntity<>(service.patchUser(userId, request), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    ResponseEntity<UserLightDTO> getUserByPhoneNumber(@PathVariable(ParamKeys.PARAM_PHONE_NUMBER) String phoneNumber) {
        return ResponseEntity.ok(service.getByPhoneNumber(phoneNumber));
    }
}

