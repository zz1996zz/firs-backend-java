package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.service.FavoriteService;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    //관심상품 등록
    @PostMapping("/card")
    public FavoriteItem insertFavoriteCard(@RequestBody MemberForm reqMember,
                                           @RequestBody CardForm reqCard){
        return favoriteService.insertFavoriteCard(reqMember,reqCard);
    }


    //관심상품 해지
    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable long id){
        favoriteService.deleteFavorite(id);
    }

    //관심상품 조회
    @GetMapping
    public void getFavorites(MemberForm reqMember){
        favoriteService.getFavorites(reqMember);
    }

}
