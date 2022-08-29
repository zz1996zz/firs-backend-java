package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardForm {
    private String productType;
    private String cardName;

    private String cardCompany;

    private String annualFee;

    private String cardType;

    private String cardDescription;

    private String franchisee;

    private String shopping;

    private String oiling;

    private String insurance;

    private String cafe;

    private String tag;

    //카드 등록시 사용
    @Builder
    public CardForm(String productType, String cardName, String cardCompany, String annualFee, String cardType, String cardDescription, String franchisee, String shopping, String oiling, String insurance, String cafe, String tag) {
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

    //카드 수정시 사용
    public Card toEntity() {
        return Card.builder()
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
    }

    //카드 조회시 사용
    public CardForm(Card entity) {
        this.productType = entity.getProductType();
        this.cardName = entity.getCardName();
        this.cardCompany = entity.getCardCompany();
        this.annualFee = entity.getAnnualFee();
        this.cardType = entity.getCardType();
        this.cardDescription = entity.getCardDescription();
        this.franchisee = entity.getFranchisee();
        this.shopping = entity.getShopping();
        this.oiling = entity.getOiling();
        this.insurance = entity.getInsurance();
        this.cafe = entity.getCafe();
        this.tag = entity.getTag();
    }
}
