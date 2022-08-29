package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;

    // 카드 등록
    @Transactional
    public Long save(CardForm cardForm) {
        return cardRepository.save(cardForm.toEntity()).getId();
    }

    // 카드 수정
    @Transactional
    public Long update(Long id, CardForm cardForm) {
        Card card = cardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        card.update(cardForm.getProductType(), cardForm.getCardName(), cardForm.getAnnualFee(), cardForm.getCardType(), cardForm.getSubjectToJoin(), cardForm.getExplanation());

        return id;
    }

    // 카드 조회
    public CardForm findById(Long id) {
        Card entity = cardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new CardForm(entity);
    }
}
