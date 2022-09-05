package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Card;
import lombok.Data;

@Data
public class CardForm {
    private long cardId;
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
    private String img;

    //카드 조회시 사용
    public CardForm(Card card) {
        this.cardId = card.getCardId();
        this.productType = card.getProductType();
        this.cardName = card.getCardName();
        this.cardCompany = card.getCardCompany();
        this.annualFee = card.getAnnualFee();
        this.cardType = card.getCardType();
        this.cardDescription = card.getCardDescription();
        this.franchisee = card.getFranchisee();
        this.shopping = card.getShopping();
        this.oiling = card.getOiling();
        this.insurance = card.getInsurance();
        this.cafe = card.getCafe();
        this.tag = card.getTag();
        this.img = card.getImg();
    }
}
