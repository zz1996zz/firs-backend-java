package fastcampus.saladbank.biz.service;


import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.CartRepository;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
@Slf4j
public class CartService {

    private final CartRepository cartRepository;
    private final CardRepository cardRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;


    //장바구니 조회
    public Cart getCarts(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        return cartRepository.findByMember(member);
    }

    //장바구니 추가(대출)
    @Transactional
    public Cart insertLoan(MemberForm memberForm, long loanId) {
        //member 찾기
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        //cart 찾기
        Cart cart = cartRepository.findByMember(member);
        //loan 찾기
        Loan loan = loanRepository.findById(loanId).orElse(null);
        //cartItem에 loan 추가
        cart.addCartLoan(loan);
        return cartRepository.save(cart);
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
        cart.addCartCard(card);
        cartRepository.save(cart);
    }

    //장바구니 비우기(전체)
    @Transactional
    public void deleteAllCart(MemberForm memberForm) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        cart.getCardList().removeAll(cardRepository.findAll());
        cart.getLoanList().removeAll(loanRepository.findAll());
    }

    //장바구니 단건삭제(카드)
    @Transactional
    public void deleteCartCard(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        Optional<Card> card = cardRepository.findById(id);

        card.ifPresent(value -> cart.getCardList().remove(value));
    }

    //장바구니 단건삭제(대출)
    @Transactional
    public void deleteCartLoan(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Cart cart = cartRepository.findByMember(member);
        Optional<Loan> loan = loanRepository.findById(id);
        loan.ifPresent(value -> cart.getLoanList().remove(value));
    }
}
