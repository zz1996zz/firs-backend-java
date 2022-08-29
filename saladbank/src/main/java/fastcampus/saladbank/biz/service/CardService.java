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

    @Transactional
    public Long save(CardForm cardForm) {
        return cardRepository.save(cardForm.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CardForm cardForm) {
        Card card = cardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        card.update(cardForm.getProductType(), cardForm.getCardName(), cardForm.getAnnualFee(), cardForm.getCardType(), cardForm.getSubjectToJoin(), cardForm.getExplanation());

        return id;
    }
}
