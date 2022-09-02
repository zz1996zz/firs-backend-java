package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.CartService;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.CardDto;
import fastcampus.saladbank.web.dto.LoanDto;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
@Slf4j
public class CartController {


    private final CartService cartService;

    //장바구니 조회(카드)
    @GetMapping("/card")
    public List<CardDto.Response> getCartsCard(@Login MemberForm memberForm ){
        return cartService.getCartsCard(memberForm);
    }

    //장바구니 조회(대출)
    @GetMapping("/loan")
    public List<LoanDto.Response> getCartsLoan(@Login MemberForm memberForm ){
        return cartService.getCartsLoan(memberForm);
    }
    
    //장바구니 추가(카드)
    @PostMapping("/card")
    public void insertCartCard(@Login MemberForm memberForm,
                           @RequestBody Map<String,Long> map){
        cartService.insertCartCard(memberForm, map.get("card_id"));
    }

    //장바구니 추가(대출)
    @PostMapping("/loan")
    public void insertCartLoan(@Login MemberForm memberForm,
                           @RequestBody Map<String,Long> map){
         cartService.insertCartLoan(memberForm, map.get("loan_id"));
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