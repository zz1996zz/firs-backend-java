package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.FavoriteService;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.CardDto;
import fastcampus.saladbank.web.dto.LoanDto;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    //관심상품 등록(카드)
    @PostMapping("/card")
    public CardDto.Response insertFavoriteCard(@Login MemberForm reqMember,
                                               @RequestBody Map<String,Long> map ){
        return favoriteService.insertFavoriteCard(reqMember, map.get("card_id"));
    }

    //관심상품 등록(카드)
    @PostMapping("/loan")
    public LoanDto.Response insertFavoriteLoan(@Login MemberForm reqMember,
                                               @RequestBody Map<String,Long> map ){
        return favoriteService.insertFavoriteLoan(reqMember, map.get("loan_id"));
    }

    //관심상품 삭제(전체)
    @DeleteMapping()
    public void deleteFavorite(@Login MemberForm memberForm){
        favoriteService.deleteFavorite(memberForm);
    }

    //관심상품 삭제(카드)
    @DeleteMapping("/card/{id}")
    public void deleteFavoriteCard(@Login MemberForm memberForm,
                                   @PathVariable long id){
        favoriteService.deleteCartCard(memberForm,id);
    }

    //관심상품 삭제(카드)
    @DeleteMapping("/loan/{id}")
    public void deleteFavoriteLoan(@Login MemberForm memberForm,
                                   @PathVariable long id){
        favoriteService.deleteCartLoan(memberForm,id);
    }
    //관심상품 조회(카드)
    @GetMapping("/card")
    public List<CardDto.Response> getFavoritesCard(@Login MemberForm reqMember){
        return favoriteService.getFavoritesCard(reqMember);
    }

    //관심상품 조회(대출)
    @GetMapping("/loan")
    public List<LoanDto.Response> getFavoritesLoan(@Login MemberForm reqMember){
        return favoriteService.getFavoritesLoan(reqMember);
    }

}
