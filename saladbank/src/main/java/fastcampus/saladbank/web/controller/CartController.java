package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CartItemRepository;
import fastcampus.saladbank.biz.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {


    private final CartService cartService;

    //장바구니 조회
    @GetMapping
    public void getCarts(Member member ){
        cartService.getCarts(member);
    }

    //장바구니 추가
    @PostMapping
    public void insertCart(){
        cartService.insertCart();
    }

    //장바구니 취소
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable long id){
        cartService.deleteCart(id);
    }
}
