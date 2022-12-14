package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    List<Card> findAllByCardNameContainsOrCardCompanyContainsOrTagContains(String keyword1, String keyword2, String keyword3);
}
