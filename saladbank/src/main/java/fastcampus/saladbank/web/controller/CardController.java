package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.CardService;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CardController {

    private final CardService cardService;

    // 카드 조회
    @GetMapping("/card/view/{id}")
    public CardForm findById(@PathVariable Long id) {
        return cardService.findById(id);
    }
}
