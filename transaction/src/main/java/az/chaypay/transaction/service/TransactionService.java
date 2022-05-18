package az.chaypay.transaction.service;

import az.chaypay.shared.transaction.CreateTransactionRequest;
import az.chaypay.shared.transaction.CreateTransactionResponse;
import az.chaypay.shared.transaction.TransactionResponse;

import java.util.List;

public interface TransactionService {

    List<TransactionResponse> getAllByUserId(Long userId);

    List<TransactionResponse> getAllByTeamId(Long teamId);

    CreateTransactionResponse createTransaction(CreateTransactionRequest request);

}
