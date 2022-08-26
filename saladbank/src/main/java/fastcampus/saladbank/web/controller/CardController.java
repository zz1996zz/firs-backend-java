package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.CardService;
import fastcampus.saladbank.web.dto.CardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CardController {

    private final CardService cardService;

    @PostMapping("/card/register")
    public Long save(@RequestBody CardForm cardForm) {
        return cardService.save(cardForm);
    }
}
