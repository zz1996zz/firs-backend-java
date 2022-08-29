package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.service.FavoriteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FavoriteItemController {

    private final FavoriteItemService favoriteItemService;


}
