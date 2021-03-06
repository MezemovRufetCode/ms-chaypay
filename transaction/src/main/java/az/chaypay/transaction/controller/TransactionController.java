package az.chaypay.transaction.controller;

import az.chaypay.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/")
public class TransactionController {
    private final TransactionService service;
}
