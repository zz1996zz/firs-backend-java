package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final LoanRepository loanRepository;



    //관심상품 조회
    public Favorite getFavorites(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        return favoriteRepository.findByMember(member);
    }

    //관심상품 추가 (카드)
    @Transactional
    public Favorite insertFavoriteCard(MemberForm reqMember, long cardId) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Card card = cardRepository.findById(cardId).orElse(null);
        favorite.addCard(card);
        return favoriteRepository.save(favorite);

    }

    //관심상품 추가 (대출)
    @Transactional
    public Favorite insertFavoriteLoan(MemberForm reqMember, long loanId) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Loan loan = loanRepository.findById(loanId).orElse(null);
        favorite.addLoan(loan);
        return favoriteRepository.save(favorite);

    }
    //관심상품 삭제(카드)
    @Transactional
    public void deleteCartCard(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Optional<Card> card = cardRepository.findById(id);
        card.ifPresent(value -> favorite.getCardList().remove(value));

    }

    //관심상품 삭제(대출)
    @Transactional
    public void deleteCartLoan(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Optional<Loan> loan = loanRepository.findById(id);
        loan.ifPresent(value -> favorite.getLoanList().remove(value));

    }

    //관심상품 전체삭제
    @Transactional
    public void deleteFavorite(MemberForm memberForm) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        favorite.getCardList().removeAll(cardRepository.findAll());
        favorite.getLoanList().removeAll(loanRepository.findAll());
    }

}
