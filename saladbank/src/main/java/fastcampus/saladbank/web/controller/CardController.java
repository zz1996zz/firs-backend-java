package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.CardService;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CardController {

    private final CardService cardService;

    // 카드 등록
    @PostMapping("/card/register")
    public Long save(@RequestBody CardForm cardForm) {
        return cardService.save(cardForm);
    }

    // 카드 수정
    @PutMapping("/card/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody CardForm cardForm) {
        return cardService.update(id, cardForm);
    }
}
