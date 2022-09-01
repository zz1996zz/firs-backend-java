package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.service.CartService;
import fastcampus.saladbank.config.auth.PrincipalDetails;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
    public Cart getCarts(@Login MemberForm memberForm ){
        return cartService.getCarts(memberForm);
    }
    
    //장바구니 추가(카드)
    @PostMapping("/card")
    public void insertCard(@Login MemberForm memberForm,
                           @RequestBody Map<String,Long> map){
        cartService.insertCard(memberForm, map.get("card_id"));
    }

    //장바구니 추가(대출)
    @PostMapping("/loan")
    public Cart insertLoan(@Login MemberForm memberForm,
                           @RequestBody Map<String,Long> map){

        return cartService.insertLoan(memberForm, map.get("loan_id"));
    }

    //장바구니 비우기(전체삭제)
    @DeleteMapping
    public void deleteCart(@Login MemberForm memberForm){
        cartService.deleteAllCart(memberForm);
    }

    //장바구니 삭제(카드)
    @DeleteMapping("/card/{id}")
    public void deleteCartCard(@Login MemberForm memberForm,
                               @PathVariable long id){
        cartService.deleteCartCard(memberForm,id);
    }

    //장바구니 삭제(대출)
    @DeleteMapping("/loan/{id}")
    public void deleteCartLoan(@Login MemberForm memberForm,
                               @PathVariable long id){
        cartService.deleteCartLoan(memberForm,id);
    }
}