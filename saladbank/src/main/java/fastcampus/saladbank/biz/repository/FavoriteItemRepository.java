package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.domain.FavoriteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteItemRepository extends JpaRepository<FavoriteItem,Long> {
    void deleteAllByFavoriteId(long id);

    List<FavoriteItem> findByFavorite(Favorite favorite);
}
