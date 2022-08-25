package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.domain.FavoriteItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteItemRepository extends JpaRepository<FavoriteItem,Long> {
}
