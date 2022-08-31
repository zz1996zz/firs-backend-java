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

    // 카드 조회
    public CardForm findById(Long id) {
        Card entity = cardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 카드가 없습니다. id=" + id));

        return new CardForm(entity);
    }
}
