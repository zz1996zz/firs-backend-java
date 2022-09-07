package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
import fastcampus.saladbank.web.dto.CardDto;
import fastcampus.saladbank.web.dto.LoanDto;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteItemRepository favoriteItemRepository;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final LoanRepository loanRepository;

    //관심상품 조회(카드)
    public List<CardDto.Response> getFavoritesCard(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Favorite favorite = favoriteRepository.findByMember(Optional.ofNullable(member));
        return favoriteItemRepository.findAllByFavorite(favorite)
                .stream()
                .map(favoriteItem -> CardDto.Response.of(favoriteItem.getCard()))
                .collect(Collectors.toList());

    }

    //관심상품 조회(대출)
    public List<LoanDto.Response> getFavoritesLoan(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Favorite favorite = favoriteRepository.findByMember(Optional.ofNullable(member));
        return favoriteItemRepository.findAllByFavorite(favorite)
                .stream()
                .map(favoriteItem -> LoanDto.Response.of(favoriteItem.getLoan()))
                .collect(Collectors.toList());

    }

    //관심상품 추가 (카드)
    @Transactional
    public CardDto.Response insertFavoriteCard(MemberForm reqMember, long cardId) {
        //member 찾기
        String username = reqMember.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        //cart 찾기
        Favorite favorite = favoriteRepository.findByMember(Optional.ofNullable(member));
        //card 찾기
        Card card = cardRepository.findById(cardId).orElse(null);
        //카트에 추가
        FavoriteItem favoriteItem = FavoriteItem.builder()
                .favorite(favorite)
                .card(card)
                .build();
        favorite.getFavoriteItems().forEach(favoriteItem1 -> {
            if(favoriteItem1.getCard().equals(card)){
                throw new RuntimeException("이미 추가된 상품입니다");
            }
        });

        favorite.addFavoriteItem(favoriteItem);
        card.addFavoriteItem(favoriteItem);
        favoriteItemRepository.save(favoriteItem);
        return CardDto.Response.of(card);

    }

    //관심상품 추가 (대출)
    @Transactional
    public LoanDto.Response insertFavoriteLoan(MemberForm reqMember, long loanId) {
        //member 찾기
        String username = reqMember.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        //cart 찾기
        Favorite favorite = favoriteRepository.findByMember(Optional.ofNullable(member));
        //card 찾기
        Loan loan = loanRepository.findById(loanId).orElse(null);
        //카트에 추가
        FavoriteItem favoriteItem = FavoriteItem.builder()
                .favorite(favorite)
                .loan(loan)
                .build();
        favorite.getFavoriteItems().forEach(favoriteItem1 -> {
            if(favoriteItem1.getLoan().equals(loan)){
                throw new RuntimeException("이미 추가된 상품입니다");
            }
        });

        favorite.addFavoriteItem(favoriteItem);
        loan.addFavoriteItem(favoriteItem);
        favoriteItemRepository.save(favoriteItem);
        return LoanDto.Response.of(loan);

    }

    //관심상품 삭제(카드)
    @Transactional
    public void deleteCartCard(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Card card = cardRepository.findById(id).orElse(null);
        FavoriteItem favoriteItem = favoriteItemRepository.findByCardAndFavorite(card,favorite);
        favoriteItemRepository.delete(favoriteItem);

    }

    //관심상품 삭제(대출)
    @Transactional
    public void deleteCartLoan(MemberForm memberForm, long id) {
        String username = memberForm.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Loan loan = loanRepository.findById(id).orElse(null);
        FavoriteItem favoriteItem = favoriteItemRepository.findByLoanAndFavorite(loan,favorite);
        favoriteItemRepository.delete(favoriteItem);
    }

    //관심상품 전체삭제
    @Transactional
    public void deleteFavorite(MemberForm memberForm) {
        String username = memberForm.getUsername();
        Member member = memberRepository.findByUsername(username).orElse(null);
        Favorite favorite = favoriteRepository.findByMember(Optional.ofNullable(member));
        favoriteItemRepository.deleteAllByFavorite(favorite);
    }

}
