package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;

    // 카드 조회
    public CardForm findById(Long id) {
        Card entity = cardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 카드가 없습니다. id=" + id));

        return new CardForm(entity);
    }
}
