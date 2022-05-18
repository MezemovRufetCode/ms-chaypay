package az.chaypay.transaction.repository;


import az.chaypay.transaction.repository.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT transaction FROM Transaction transaction " +
           "WHERE transaction.userId = :userId " +
           "AND transaction.status = az.chaypay.shared.transaction.TransactionStatus.SUCCESS")
    List<Transaction> getAllByUserId(@Param("userId") Long userId);

    @Query("SELECT transaction FROM Transaction transaction " +
           "WHERE transaction.teamId = :teamId " +
           "AND transaction.status = az.chaypay.shared.transaction.TransactionStatus.SUCCESS")
    List<Transaction> getAllByTeamId(@Param("teamId") Long teamId);
}