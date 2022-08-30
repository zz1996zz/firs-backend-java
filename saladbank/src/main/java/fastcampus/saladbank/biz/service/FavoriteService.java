package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteItemRepository favoriteItemRepository;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final LoanRepository loanRepository;

    //관심상품 전체삭제
    @Transactional
    public void deleteFavorite(MemberForm memberForm) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        FavoriteItem favoriteItem = favoriteItemRepository.findByFavorite(favorite);
        favoriteItem.getCardList().removeAll(cardRepository.findAll());
        favoriteItem.getLoanList().removeAll(loanRepository.findAll());
    }


    //관심상품 조회
    public FavoriteItem getFavorites(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        return favoriteItemRepository.findByFavorite(favorite);
    }

    //관심상품 추가 (카드)
    @Transactional
    public FavoriteItem insertFavoriteCard(MemberForm reqMember, long cardId) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Card card = cardRepository.findById(cardId).orElse(null);
        FavoriteItem favoriteItem = favoriteItemRepository.findByFavorite(favorite);
        favoriteItem.addCard(card);
        return favoriteItemRepository.save(favoriteItem);

    }

    //관심상품 추가 (대출)
    @Transactional
    public FavoriteItem insertFavoriteLoan(MemberForm reqMember, long loanId) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Loan loan = loanRepository.findById(loanId).orElse(null);
        FavoriteItem favoriteItem = favoriteItemRepository.findByFavorite(favorite);
        favoriteItem.addLoan(loan);
        return favoriteItemRepository.save(favoriteItem);

    }
    //관심상품 삭제(카드)
    @Transactional
    public void deleteCartCard(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        FavoriteItem favoriteItem = favoriteItemRepository.findByFavorite(favorite);
        Optional<Card> card = cardRepository.findById(id);
        if(card.isPresent()){
            favoriteItem.getCardList().remove(card.get());
            log.info(card.get().getCardName()+"이(가) 삭제되었습니다.");
        } else {
            log.info("카드가 존재하지않습니다");
        }

    }

    //관심상품 삭제(대출)
    @Transactional
    public void deleteCartLoan(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        FavoriteItem favoriteItem = favoriteItemRepository.findByFavorite(favorite);
        Optional<Loan> loan = loanRepository.findById(id);
        loan.ifPresent(value -> favoriteItem.getLoanList().remove(value));

    }
}
