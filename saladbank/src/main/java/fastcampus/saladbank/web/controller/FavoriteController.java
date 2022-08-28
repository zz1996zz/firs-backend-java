package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    //관심상품 등록
    @PostMapping
    public void insertFavorite(){
        favoriteService.insertFavorite();
    }

    //관심상품 해지
    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable long id){
        favoriteService.deleteFavorite(id);
    }

    //관심상품 조회
    @GetMapping
    public List<FavoriteItem> getFavorites(Member member){
        return favoriteService.getFavorites(member);
    }

}
