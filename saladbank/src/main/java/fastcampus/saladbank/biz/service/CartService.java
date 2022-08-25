package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.CartItem;
import fastcampus.saladbank.biz.repository.CartItemRepository;
import fastcampus.saladbank.biz.repository.CartRepository;
import fastcampus.saladbank.biz.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    //장바구니 조회
    public void getCarts() {
    }

    //장바구니 추가
    @Transactional
    public void insertCart() {
    }

    //장바구니 삭제
    @Transactional
    public void deleteCart(long id) {
        cartItemRepository.deleteAllByCartId(id);
    }
}
