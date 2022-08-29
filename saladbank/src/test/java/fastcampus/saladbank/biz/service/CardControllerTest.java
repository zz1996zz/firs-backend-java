package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.repository.CardRepository;
import fastcampus.saladbank.web.dto.CardForm;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

        CardForm cardForm = CardForm.builder()
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
        assertThat(all.get(0).getCardCompany()).isEqualTo(cardCompany);
        assertThat(all.get(0).getAnnualFee()).isEqualTo(annualFee);
        assertThat(all.get(0).getCardType()).isEqualTo(cardType);
        assertThat(all.get(0).getCardDescription()).isEqualTo(cardDescription);
        assertThat(all.get(0).getFranchisee()).isEqualTo(franchisee);
        assertThat(all.get(0).getShopping()).isEqualTo(shopping);
        assertThat(all.get(0).getOiling()).isEqualTo(oiling);
        assertThat(all.get(0).getInsurance()).isEqualTo(insurance);
        assertThat(all.get(0).getCafe()).isEqualTo(cafe);
        assertThat(all.get(0).getTag()).isEqualTo(tag);
    }

    @Test
    public void Card_수정() throws Exception {
        //given
        Card saveCard = cardRepository.save(Card.builder()
                .productType("가")
                .cardName("나")
                .cardCompany("다")
                .annualFee("라")
                .cardType("마")
                .cardDescription("바")
                .franchisee("사")
                .shopping("아")
                .oiling("자")
                .insurance("차")
                .cafe("카")
                .tag("타")
                .build());

        Long updateId = saveCard.getId();
        String expectedProductType = "A";
        String expectedCardName = "B";
        String expectedCardCompany = "C";
        String expectedAnnualFee = "D";
        String expectedCardType = "E";
        String expectedCardDescription = "F";
        String expectedFranchisee = "G";
        String expectedShopping = "H";
        String expectedOiling = "I";
        String expectedInsurance = "J";
        String expectedCafe = "K";
        String expectedTag = "L";

        CardForm cardForm = CardForm.builder()
                .productType(expectedProductType)
                .cardName(expectedCardName)
                .cardCompany(expectedCardCompany)
                .annualFee(expectedAnnualFee)
                .cardType(expectedCardType)
                .cardDescription(expectedCardDescription)
                .franchisee(expectedFranchisee)
                .shopping(expectedShopping)
                .oiling(expectedOiling)
                .insurance(expectedInsurance)
                .cafe(expectedCafe)
                .tag(expectedTag)
                .build();

        String url = "http://localhost:" + port + "/card/update/" + updateId;

        HttpEntity<CardForm> requestEntity = new HttpEntity<>(cardForm);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Card> all = cardRepository.findAll();
        assertThat(all.get(0).getProductType()).isEqualTo(expectedProductType);
        assertThat(all.get(0).getCardName()).isEqualTo(expectedCardName);
        assertThat(all.get(0).getCardCompany()).isEqualTo(expectedCardCompany);
        assertThat(all.get(0).getAnnualFee()).isEqualTo(expectedAnnualFee);
        assertThat(all.get(0).getCardType()).isEqualTo(expectedCardType);
        assertThat(all.get(0).getCardDescription()).isEqualTo(expectedCardDescription);
        assertThat(all.get(0).getFranchisee()).isEqualTo(expectedFranchisee);
        assertThat(all.get(0).getShopping()).isEqualTo(expectedShopping);
        assertThat(all.get(0).getOiling()).isEqualTo(expectedOiling);
        assertThat(all.get(0).getInsurance()).isEqualTo(expectedInsurance);
        assertThat(all.get(0).getCafe()).isEqualTo(expectedCafe);
        assertThat(all.get(0).getTag()).isEqualTo(expectedTag);

    }
}