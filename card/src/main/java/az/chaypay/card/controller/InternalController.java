package az.chaypay.card.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/internal")
public class InternalController {

//    private final CardService service;
//
//    @GetMapping("/{userId}")
//    ResponseEntity<SimpleCardInfoResponse> getSimpleCardInfo(
//            @PathVariable Long userId
//    ) {
//        return ResponseEntity.ok(service.getSimpleCardInfo(userId));
//    }
}
