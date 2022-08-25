package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
}
