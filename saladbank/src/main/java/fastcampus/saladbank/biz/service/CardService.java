package fastcampus.saladbank.biz.service;

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
}
