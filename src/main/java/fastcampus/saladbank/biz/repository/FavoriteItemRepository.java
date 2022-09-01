package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface FavoriteItemRepository extends JpaRepository<FavoriteItem,Long> {
    List<FavoriteItem> findAllByFavorite(Favorite favorite);

    FavoriteItem findByCard(Card card);

    FavoriteItem findByLoan(Loan loan);

    void deleteAllByFavorite(Favorite favorite);
}
