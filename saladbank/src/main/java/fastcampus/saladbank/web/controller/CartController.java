package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.CartItem;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.service.CartService;
import fastcampus.saladbank.config.auth.PrincipalDetails;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {


    private final CartService cartService;

    //장바구니 조회
    @GetMapping
    public List<CartItem> getCarts(@RequestBody MemberForm reqMember ){
        return cartService.getCarts(reqMember);
    }
    
    //장바구니 추가(카드)
    @PostMapping("/card")
    public void insertCard(Authentication authentication,
                           @RequestBody Map<String,Long> map){
//        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//        String username = principal.getMember().getUsername();

        cartService.insertCard("wnsdn4875", map.get("cardId"));
    }

    //장바구니 추가(대출)
    @PostMapping("/loan")
    public CartItem insertLoan(@RequestBody Map<String,Long> map){
        CartItem cartItem = cartService.insertLoan("wnsdn4875", map.get("cardId"));
        return cartItem;
    }

    //장바구니 비우기(전체삭제)
    @DeleteMapping
    public void deleteCart(){
        cartService.deleteAllCart("wnsdn4875");
    }

    //장바구니 삭제(카드)
    @DeleteMapping("/card/{id}")
    public void deleteCartCard(@PathVariable long id){
        cartService.deleteCartCard("wnsdn4875",id);
    }

    //장바구니 삭제(카드)
    @DeleteMapping("/loan/{id}")
    public void deleteCartLoan(@PathVariable long id){
        cartService.deleteCartLoan("wnsdn4875",id);
    }
}