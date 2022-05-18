package az.chaypay.card.repository.entity;

import az.chaypay.card.model.CardStatus;
import az.chaypay.shared.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cards", schema = "cards")
public class Card extends BaseEntity {

    private Long userId;

    private String cif;

    private String cardholderName;

    private String cardholderSurname;

    private String phoneNumber;

    private String wpan;

    private LocalDateTime expirationDate;

    @Enumerated(EnumType.STRING)
    private CardStatus status = CardStatus.INITIALIZED;

    private String statusDescription;
}