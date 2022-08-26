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
    private String annualFee;
    private String cardType;
    private String subjectToJoin;
    private String explanation;
    @Builder
    public CardForm(String productType, String cardName, String annualFee, String cardType, String subjectToJoin, String explanation) {
        this.productType = productType;
        this.cardName = cardName;
        this.annualFee = annualFee;
        this.cardType = cardType;
        this.subjectToJoin = subjectToJoin;
        this.explanation = explanation;
    }

    public Card toEntity() {
        return Card.builder()
                .productType(productType)
                .cardName(cardName)
                .annualFee(annualFee)
                .cardType(cardType)
                .subjectToJoin(subjectToJoin)
                .explanation(explanation)
                .build();
    }
}
