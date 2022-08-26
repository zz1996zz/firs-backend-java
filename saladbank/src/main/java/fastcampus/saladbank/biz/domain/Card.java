package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CARD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Card {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "CARD_NAME", nullable = false)
    private String cardName; //카드이름

    @Column(name = "ANNUAL_FEE", nullable = false)
    private String annualFee; //연회비

    @Column(name = "CARD_TYPE", nullable = false)
    private String cardType; // 카드 종류 (체크 or 신용)

    @Column(name = "SUBJECT_TO_JOIN", nullable = false)
    private String subjectToJoin; //가입 대상

    @Column(name = "DESC", nullable = false)
    private String desc; // 요약설명
}
// 카드상품 : 연회비, 카드 종류(체크인지 신용인지), 가입대상, 카드 이름, 요약설명