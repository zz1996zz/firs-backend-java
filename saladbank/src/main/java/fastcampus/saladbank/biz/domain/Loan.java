package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LOAN")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Loan extends BaseTime {

    @Id
    @Column(name = "LOAN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "LOAN_NAME", nullable = false)
    private String loanName; // 상품명

    @Column(name = "LOAN_TYPE", nullable = false)
    private String loanType; // 상품유형

    @Column(name = "CREDIT_LINE", nullable = false)
    private String creditLine; // 대출한도

    @Column(name = "SBSCRQST", nullable = false)
    private String sbscRqst; // 가입요건

    @Column(name = "RATE", nullable = false)
    private double rate; // 금리

    @Column(name = "PERIOD")
    private int period; // 대출기간

    @Column(name = "TAG", nullable = false)
    private String tag; // ex) 주부, 프리랜서, 모바일, 1금융권
}
// 대출상품 : 대출한도, 금리, 대출 기간, 상품명, 상품유형, 가입요건