package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    @Query(value = "SELECT CARD.card_id, CARD.createdDate, CARD.modifiedDate, CARD.PRODUCT_TYPE, CARD.CARD_NAME, CARD.CARD_COMPANY, CARD.ANNUAL_FEE, CARD.CARD_TYPE, CARD.CARD_DESCRIPTION, CARD.FRANCHISEE, CARD.SHOPPING, CARD.OILING, CARD.INSURANCE, CARD.CAFE, CARD.TAG, CARD.IMG FROM CARD WHERE CARD.CARD_NAME LIKE %:keyword% OR CARD.CARD_COMPANY LIKE %:keyword% OR CARD.TAG LIKE %:keyword%", nativeQuery = true)
    List<Card> findAllByCardInfo(@Param("keyword") String keyword);

    @Query(value = "SELECT CARD.card_id, CARD.createdDate, CARD.modifiedDate, CARD.PRODUCT_TYPE, CARD.CARD_NAME, CARD.CARD_COMPANY, CARD.ANNUAL_FEE, CARD.CARD_TYPE, CARD.CARD_DESCRIPTION, CARD.FRANCHISEE, CARD.SHOPPING, CARD.OILING, CARD.INSURANCE, CARD.CAFE, CARD.TAG, CARD.IMG FROM CARD", nativeQuery = true)
    List<Card> findCardAll();
}
