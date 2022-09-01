package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CardDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {

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

        public static Response of(Card card) {
            return Response.builder()
                    .productType(card.getProductType())
                    .cardName(card.getCardName())
                    .annualFee(card.getAnnualFee())
                    .cardType(card.getCardType())
                    .cardDescription(card.getCardDescription())
                    .franchisee(card.getFranchisee())
                    .shopping(card.getShopping())
                    .oiling(card.getOiling())
                    .insurance(card.getInsurance())
                    .cafe(card.getCafe())
                    .tag(card.getTag())
                    .build();

        }
    }
}
