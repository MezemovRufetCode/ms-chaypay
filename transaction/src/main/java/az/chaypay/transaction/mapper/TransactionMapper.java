package az.chaypay.transaction.mapper;

import az.chaypay.shared.transaction.CreateTransactionRequest;
import az.chaypay.shared.transaction.TransactionResponse;
import az.chaypay.transaction.repository.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class TransactionMapper {

    public static final TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "status", ignore = true)
    public abstract Transaction toTransactionEntity(CreateTransactionRequest request);

    public abstract TransactionResponse toTransactionResponse(Transaction transaction);
}
