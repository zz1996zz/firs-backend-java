package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.web.dto.CardForm;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CardRepository cardRepository;

    @After
    public void tearDown() throws Exception {
        cardRepository.deleteAll();
    }

    @Test
    public void Card_등록() throws Exception {
        //given
        String productType = "가";
        String cardName = "나";
        String annualFee = "다";
        String cardType = "라";
        String subjectToJoin = "마";
        String explanation = "바";
        CardForm cardForm = CardForm.builder()
                .productType(productType)
                .cardName(cardName)
                .annualFee(annualFee)
                .cardType(cardType)
                .subjectToJoin(subjectToJoin)
                .explanation(explanation)
                .build();

        String url = "http://localhost:" + port + "/card/register";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, cardForm, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Card> all = cardRepository.findAll();
        assertThat(all.get(0).getProductType()).isEqualTo(productType);
        assertThat(all.get(0).getCardName()).isEqualTo(cardName);
        assertThat(all.get(0).getAnnualFee()).isEqualTo(annualFee);
        assertThat(all.get(0).getCardType()).isEqualTo(cardType);
        assertThat(all.get(0).getSubjectToJoin()).isEqualTo(subjectToJoin);
        assertThat(all.get(0).getExplanation()).isEqualTo(explanation);
    }
}