package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.CartItem;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CartItemRepository;
import fastcampus.saladbank.biz.repository.CartRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;

    //장바구니 조회
    public List<CartItem> getCarts(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        List<CartItem> cartItem = cartItemRepository.findAllByCart(cart);
        return cartItem;
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
