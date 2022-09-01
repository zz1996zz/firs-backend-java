package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CARD")
@Entity
public class Card extends BaseTime {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "CARD_NAME")
    private String cardName; //카드이름

    @Column(name = "CARD_COMPANY")
    private String cardCompany; //카드회사 이름

    @Column(name = "ANNUAL_FEE")
    private String annualFee; //연회비

    @Column(name = "CARD_TYPE")
    private String cardType; // 카드 종류 (체크 or 신용)

    @Column(name = "CARD_DESCRIPTION")
    private String cardDescription; //카드 간단한 설명

    @Column(name = "FRANCHISEE")
    private String franchisee; // 가맹점 적립률 "0.3 1.0"

    @Column(name = "SHOPPING")
    private String shopping; // "10만원 당 5천 머니" 적립

    @Column(name = "OILING")
    private String oiling; // "5만원당 3천원"

    @Column(name = "INSURANCE")
    private String insurance; // "10만원 당 5천 머니"

    @Column(name = "CAFE")
    private String cafe; // "1000"

    @Column(name = "TAG")
    private String tag; // "주부 그림/운동 30대" 나이/직업/취미 하나씩 들가는 곳

    @Column(name = "IMG")
    private String img; // 이미지 주소 저장하는 곳

    @Builder
    public Card(String productType, String cardName, String cardCompany, String annualFee, String cardType, String cardDescription, String franchisee, String shopping, String oiling, String insurance, String cafe, String tag) {
        this.productType = productType;
        this.cardName = cardName;
        this.cardCompany = cardCompany;
        this.annualFee = annualFee;
        this.cardType = cardType;
        this.cardDescription = cardDescription;
        this.franchisee = franchisee;
        this.shopping = shopping;
        this.oiling = oiling;
        this.insurance = insurance;
        this.cafe = cafe;
        this.tag = tag;
    }

    public void update(String productType, String cardName, String cardCompany, String annualFee, String cardType, String cardDescription, String franchisee, String shopping, String oiling, String insurance, String cafe, String tag) {
        this.productType = productType;
        this.cardName = cardName;
        this.cardCompany = cardCompany;
        this.annualFee = annualFee;
        this.cardType = cardType;
        this.cardDescription = cardDescription;
        this.franchisee = franchisee;
        this.shopping = shopping;
        this.oiling = oiling;
        this.insurance = insurance;
        this.cafe = cafe;
        this.tag = tag;
    }

}
// 카드상품 : 연회비, 카드 종류(체크인지 신용인지), 가입대상, 카드 이름, 요약설명