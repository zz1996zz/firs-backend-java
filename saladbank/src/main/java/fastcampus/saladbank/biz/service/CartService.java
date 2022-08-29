package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
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
    private final CardRepository cardRepository;
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
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
    public CartItem insertLoan(MemberForm reqMember, long loanId) {
        //member 찾기
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //loan 찾기

        Loan loan = loanRepository.findById(loanId).orElse(null);
        CartItem cartItem = new CartItem(cart,loan);
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    @Transactional
    public CartItem insertCard(MemberForm reqMember, long cardId) {
        //member 찾기
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //card 찾기
        Card card = cardRepository.findById(cardId).orElse(null);
        CartItem cartItem = new CartItem(cart,card);
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    //장바구니 삭제
    @Transactional
    public void deleteCart(long id) {
        cartItemRepository.deleteAllByCartId(id);
    }
}
