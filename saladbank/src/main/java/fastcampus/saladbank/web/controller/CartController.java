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
    
    //장바구니 추가
    @PostMapping("/card")
    public void insertCard(Authentication authentication,
                           @RequestBody long cardId){
//        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//        String username = principal.getMember().getUsername();
        cartService.insertCard("wnsdn4875", cardId);
    }

    @PostMapping("/loan")
    public CartItem insertLoan(@RequestBody MemberForm reqMember, long loanId){
        CartItem cartItem = cartService.insertLoan(reqMember, loanId);
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
}
