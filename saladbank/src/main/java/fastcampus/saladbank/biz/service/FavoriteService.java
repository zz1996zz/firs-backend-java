package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.biz.repository.FavoriteItemRepository;
import fastcampus.saladbank.biz.repository.FavoriteRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.CardForm;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteItemRepository favoriteItemRepository;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;

    //관심상품 삭제
    @Transactional
    public void deleteFavorite(long id) {
        Optional<Favorite> favorite = favoriteRepository.findById(id);
        favoriteItemRepository.deleteAllByFavorite(favorite);
    }

    //관심상품 추가
    @Transactional
    public void insertFavorite() {
    }
    //관심상품 조회
    public List<FavoriteItem> getFavorites(MemberForm reqMember) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        return favoriteItemRepository.findAllByFavorite(favorite);
    }

    //관심상품 추가 (카드)
    @Transactional
    public FavoriteItem insertFavoriteCard(MemberForm reqMember, CardForm reqCard) {
        String username = reqMember.getUsername();
        Optional<Member> member = memberRepository.findByUsername(username);
        Favorite favorite = favoriteRepository.findByMember(member);
        Card card = cardRepository.findByCardName(reqCard.getCardName());
        FavoriteItem favoriteItem = new FavoriteItem(favorite,card);
        return favoriteItemRepository.save(favoriteItem);

    }
}
