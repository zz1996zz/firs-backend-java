package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.repository.CardRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    @After
    public void cleanup() {
        cardRepository.deleteAll();
    }

    @Test
    public void Card_불러오기() {
        //given
        String productType = "가";
        String cardName = "나";
        String cardCompany = "다";
        String annualFee = "라";
        String cardType = "마";
        String cardDescription = "바";
        String franchisee = "사";
        String shopping = "아";
        String oiling = "자";
        String insurance = "차";
        String cafe = "카";
        String tag = "타";

        cardRepository.save(Card.builder()
                .productType(productType)
                .cardName(cardName)
                .cardCompany(cardCompany)
                .annualFee(annualFee)
                .cardType(cardType)
                .cardDescription(cardDescription)
                .franchisee(franchisee)
                .shopping(shopping)
                .oiling(oiling)
                .insurance(insurance)
                .cafe(cafe)
                .tag(tag)
                .build());

        //when
        List<Card> cardList = cardRepository.findAll();

        //then
        Card cards = cardList.get(0);
        assertThat(cards.getProductType()).isEqualTo(productType);
        assertThat(cards.getCardName()).isEqualTo(cardName);
        assertThat(cards.getCardCompany()).isEqualTo(cardCompany);
        assertThat(cards.getAnnualFee()).isEqualTo(annualFee);
        assertThat(cards.getCardType()).isEqualTo(cardType);
        assertThat(cards.getCardDescription()).isEqualTo(cardDescription);
        assertThat(cards.getFranchisee()).isEqualTo(franchisee);
        assertThat(cards.getShopping()).isEqualTo(shopping);
        assertThat(cards.getOiling()).isEqualTo(oiling);
        assertThat(cards.getInsurance()).isEqualTo(insurance);
        assertThat(cards.getCafe()).isEqualTo(cafe);
        assertThat(cards.getTag()).isEqualTo(tag);
    }
}
