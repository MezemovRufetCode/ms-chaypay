package az.chaypay.card.service;

import az.chaypay.shared.card.SimpleCardInfoResponse;

public interface CardService {

    SimpleCardInfoResponse getSimpleCardInfo(Long userId);

//    CardInfoResponse getCardInfo(Long userId);
}
