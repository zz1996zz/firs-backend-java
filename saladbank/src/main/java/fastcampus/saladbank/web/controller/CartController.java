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
                           @RequestBody CardForm reqCard){
//        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//        String username = principal.getMember().getUsername();
        cartService.insertCard("wnsdn4875", reqCard);
    }

    @PostMapping("/loan")
    public CartItem insertLoan(@RequestBody MemberForm reqMember, long loanId){
        CartItem cartItem = cartService.insertLoan(reqMember, loanId);
        return cartItem;
    }

    //장바구니 취소
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable long id){
        cartService.deleteCart(id);
    }
}
