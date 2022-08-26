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
        String annualFee = "다";
        String cardType = "라";
        String subjectToJoin = "마";
        String explanation = "바";

        cardRepository.save(Card.builder()
                .productType(productType)
                .cardName(cardName)
                .annualFee(annualFee)
                .cardType(cardType)
                .subjectToJoin(subjectToJoin)
                .explanation(explanation)
                .build());

        //when
        List<Card> cardList = cardRepository.findAll();

        //then
        Card cards = cardList.get(0);
        assertThat(cards.getProductType()).isEqualTo(productType);
        assertThat(cards.getCardName()).isEqualTo(cardName);
        assertThat(cards.getAnnualFee()).isEqualTo(annualFee);
        assertThat(cards.getCardType()).isEqualTo(cardType);
        assertThat(cards.getSubjectToJoin()).isEqualTo(subjectToJoin);
        assertThat(cards.getExplanation()).isEqualTo(explanation);
    }
}
