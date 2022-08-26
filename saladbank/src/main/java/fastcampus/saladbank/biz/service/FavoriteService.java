package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.repository.FavoriteItemRepository;
import fastcampus.saladbank.biz.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        favoriteRepository.deleteById(id);
    }

    //관심상품 추가
    @Transactional
    public void insertFavorite() {
    }
    //관심상품 조회
    public void getFavorites() {
    }
}
