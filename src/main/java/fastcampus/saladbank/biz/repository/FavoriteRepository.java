package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.domain.FavoriteItem;
import fastcampus.saladbank.biz.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    Favorite findByMember(Optional<Member> member);

}
