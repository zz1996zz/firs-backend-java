package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.FavoriteService;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    //관심상품 등록
    @PostMapping("/favorites")
    public void insertFavorite(){
        favoriteService.insertFavorite();
    }

    //관심상품 해지
    @DeleteMapping("/favorites/{id}")
    public void deleteFavorite(@PathVariable long id){
        favoriteService.deleteFavorite(id);
    }

    //관심상품 조회
    @GetMapping("/favorites")
    public void getFavorites(MemberForm reqMember){
        favoriteService.getFavorites(reqMember);
    }

}
