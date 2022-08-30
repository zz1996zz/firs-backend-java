package fastcampus.saladbank.biz.service;


import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
@Slf4j
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
    public CartItem insertCard(String username, long cardId) {
//        //member 찾기
//        String username = reqMember.getUsername();
//        log.info("username: {}", reqMember.getUsername());
        Optional<Member> member = memberRepository.findByUsername(username);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //card 찾기
        Card card = cardRepository.findById(cardId).orElse(null);
        //카트에 추가
        CartItem cartItem = new CartItem(cart,card);
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    //장바구니 비우기(전체)
    @Transactional
    public void deleteAllCart(String username) {
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        cartItemRepository.deleteAllByCart(cart);
    }

    //장바구니 단건삭제(카드)
    @Transactional
    public void deleteCartCard(String username, long id) {
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        List<CartItem> cartItemList = cartItemRepository.findAllByCart(cart);
        Optional<Card> card = cardRepository.findById(id);
        for(CartItem cartItem : cartItemList){
            if(cartItem.getCardList().contains(card.get())){
                cartItemRepository.deleteById(cartItem.getId());
                log.info(card.get().getCardName() + "가 삭제되었습니다.");
            } else {
                log.info(card.get().getCardName() + "이 없습니다.");
            }
        }
    }
}
