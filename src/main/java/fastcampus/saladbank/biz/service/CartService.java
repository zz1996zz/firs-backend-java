package fastcampus.saladbank.biz.service;


import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
import fastcampus.saladbank.web.dto.CardDto;
import fastcampus.saladbank.web.dto.LoanDto;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
@Slf4j
public class CartService {

    private final CartRepository cartRepository;
    private final CardRepository cardRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;
    private final CartItemRepository cartItemRepository;

    //장바구니 조회(카드)
    public List<CardDto.Response> getCartsCard(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Cart cart = cartRepository.findByMember(member);
        return cartItemRepository.findAllByCart(cart)
                .stream()
                .map(cartItem -> CardDto.Response.of(cartItem.getCard()))
                .collect(Collectors.toList());

    }

    //장바구니 조회
    public List<LoanDto.Response> getCartsLoan(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Cart cart = cartRepository.findByMember(member);
        return cartItemRepository.findAllByCart(cart)
                .stream()
                .map(cartItem -> LoanDto.Response.of(cartItem.getLoan()))
                .collect(Collectors.toList());

    }

    //장바구니 추가(대출)
    @Transactional
    public LoanDto.Response insertCartLoan(MemberForm memberForm, long loanId) {
        //member 찾기
        String username = memberForm.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //card 찾기
        Loan loan = loanRepository.findById(loanId).orElse(null);
        //카트에 추가
        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .loan(loan)
                .build();
        cart.getCartItems().forEach(cartItem1 -> {
            if(cartItem1.getLoan().equals(loan)){
                throw new RuntimeException("이미 추가된 상품입니다");
            }
        });

        cart.addCartItem(cartItem);
        loan.addCartItem(cartItem);
        cartItemRepository.save(cartItem);
        return LoanDto.Response.of(loan);

    }

    //장바구니 추가(카드)
    @Transactional
    public CardDto.Response insertCartCard(MemberForm memberForm, long cardId) {
        //member 찾기
        String username = memberForm.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //card 찾기
        Card card = cardRepository.findById(cardId).orElse(null);
        //카트에 추가
        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .card(card)
                .build();
        log.info("카트 아이템 사이즈: {}",cartItem.getCart().getCartItems().size());
        cart.getCartItems().forEach(cartItem1 -> {
            if(cartItem1.getCard().equals(card)){
                throw new RuntimeException("이미 추가된 상품입니다");
            }
        });

        cart.addCartItem(cartItem);
        card.addCartItem(cartItem);
        cartItemRepository.save(cartItem);
        return CardDto.Response.of(card);

    }

    //장바구니 비우기(전체)
    @Transactional
    public void deleteAllCart(MemberForm memberForm) {
        String username = memberForm.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Cart cart = cartRepository.findByMember(member);
        cartItemRepository.deleteAllByCart(cart);
    }

    //장바구니 단건삭제(카드)
    @Transactional
    public void deleteCartCard(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Cart cart = cartRepository.findByMember(member);
        Card card = cardRepository.findById(id).orElse(null);
        CartItem cartItem = cartItemRepository.findByCard(card);
        cartItemRepository.delete(cartItem);


    }

    //장바구니 단건삭제(대출)
    @Transactional
    public void deleteCartLoan(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Cart cart = cartRepository.findByMember(member);
        Optional<Loan> loan = loanRepository.findById(id);
        loan.ifPresent(value -> cart.getCartItems().remove(value));
    }
}
