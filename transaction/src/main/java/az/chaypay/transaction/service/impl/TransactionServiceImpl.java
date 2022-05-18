package az.chaypay.transaction.service.impl;

import az.chaypay.shared.transaction.CreateTransactionRequest;
import az.chaypay.shared.transaction.CreateTransactionResponse;
import az.chaypay.shared.transaction.TransactionResponse;
import az.chaypay.transaction.mapper.TransactionMapper;
import az.chaypay.transaction.repository.TransactionRepository;
import az.chaypay.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Override
    public List<TransactionResponse> getAllByUserId(Long userId) {
        return repository.getAllByUserId(userId).stream()
                .map(mapper::toTransactionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionResponse> getAllByTeamId(Long teamId) {
        return repository.getAllByTeamId(teamId).stream()
                .map(mapper::toTransactionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CreateTransactionResponse createTransaction(CreateTransactionRequest request) {
        var transaction = repository.save(mapper.toTransactionEntity(request));
        //TODO: Transaction ID Type
        return new CreateTransactionResponse(transaction.getId(), null,generateUrl(transaction.getId()));
    }

    private String generateUrl(Long id) {
        return "placeholder " + id;
    }
}
