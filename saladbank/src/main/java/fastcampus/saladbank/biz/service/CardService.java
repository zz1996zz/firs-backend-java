package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardService {

    private final CardRepository cardRepository;

    public List getCardList() {
        return cardRepository.findAll();
    }

    public Card getCard(long cardId) {
        return cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다."));
    }
}
