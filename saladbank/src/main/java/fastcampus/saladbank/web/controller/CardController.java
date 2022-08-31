package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.CardService;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List getCardList() {
        return cardService.getCardList();
    }

    // 카드 조회
    @GetMapping("/card/view/{id}")
    public CardForm findById(@PathVariable Long id) {
        return cardService.findById(id);
    }
}
