package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Card;
import lombok.Data;

@Data
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

    //카드 수정시 사용
    public Card toEntity() {
        return new Card(productType, cardName, cardCompany, annualFee, cardType, cardDescription, franchisee, shopping, oiling, insurance, cafe, tag);
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
