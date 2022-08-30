package fastcampus.saladbank.biz.service;


import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
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
        return cartItemRepository.findAllByCart(cart);
    }

    //장바구니 추가(대출)
    @Transactional
    public CartItem insertLoan(MemberForm memberForm, long loanId) {
        //member 찾기
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //loan 찾기
        Loan loan = loanRepository.findById(loanId).orElse(null);
        CartItem cartItem = new CartItem(cart,loan);
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    //장바구니 추가(카드)
    @Transactional
    public void insertCard(MemberForm memberForm, long cardId) {
        //member 찾기
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //card 찾기
        Card card = cardRepository.findById(cardId).orElse(null);
        //카트에 추가
        CartItem cartItem = new CartItem(cart,card);
        cartItemRepository.save(cartItem);
    }

    //장바구니 비우기(전체)
    @Transactional
    public void deleteAllCart(MemberForm memberForm) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        cartItemRepository.deleteAllByCart(cart);
    }

    //장바구니 단건삭제(카드)
    @Transactional
    public void deleteCartCard(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        List<CartItem> cartItemList = cartItemRepository.findAllByCart(cart);
        Optional<Card> card = cardRepository.findById(id);
        for(CartItem cartItem : cartItemList){
            if(cartItem.getCardList().contains(card.get())){
                cartItemRepository.deleteById(cartItem.getCartItemId());
            }
        }
    }

    //장바구니 단건삭제(대출)
    @Transactional
    public void deleteCartLoan(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        List<CartItem> cartItemList = cartItemRepository.findAllByCart(cart);
        Optional<Loan> loan = loanRepository.findById(id);
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getLoanList().contains(loan.get())) {
                cartItemRepository.deleteById(cartItem.getCartItemId());
            }
        }
    }
}
