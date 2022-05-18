package az.chaypay.transaction.repository.entity;

import az.chaypay.shared.entity.BaseEntity;
import az.chaypay.shared.transaction.TransactionStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions", schema = "transactions")
public class Transaction extends BaseEntity {

    private Long userId;

    private Long teamId;

    @Column(precision = 19, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status = TransactionStatus.INIT;
}
