package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.CartItem;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.service.CartService;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {


    private final CartService cartService;

    //장바구니 조회
    @GetMapping
    public void getCarts(@RequestBody MemberForm reqMember ){
        cartService.getCarts(reqMember);
    }

    //장바구니 추가
    @PostMapping("/card")
    public CartItem insertCard(@RequestBody MemberForm reqMember, long cardId){
        CartItem cartItem = cartService.insertCard(reqMember, cardId);
        return cartItem;
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
