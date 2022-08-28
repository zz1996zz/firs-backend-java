package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.FavoriteItemRepository;
import fastcampus.saladbank.biz.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final FavoriteItemRepository favoriteItemRepository;

    //관심상품 삭제
    @Transactional
    public void deleteFavorite(long id) {
        favoriteItemRepository.deleteAllByFavoriteId(id);
    }

    //관심상품 추가
    @Transactional
    public void insertFavorite() {
    }
    //관심상품 조회
    public List<FavoriteItem> getFavorites(Member member) {
        Favorite favorite = favoriteRepository.findByMember(member);
        List<FavoriteItem> favoriteItemList = favoriteItemRepository.findByFavorite(favorite);
        return favoriteItemList;
    }
}
