package fastcampus.saladbank.biz.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "LOAN")
@Entity
public class Loan extends BaseTime {

    @Id
    @Column(name = "LOAN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_TYPE")
    private String productType; // 대출 or 카드

    @Column(name = "LOAN_NAME")
    private String loanName; // 상품명

    @Column(name = "LOAN_COMPANY")
    private String loanCompany; // 상품회사 교보생명

    @Column(name = "CREDIT_LINE")
    private String creditLine; // 최대대출한도

    @Column(name = "RATE")
    private String rate; // 최저금리 ~ 최대 금리 "2.8 10.2"

    @Column(name = "PRIME_RATE")
    private boolean primeRate; // 우대 금리가 있냐 없냐

    @Column(name = "PERIOD")
    private int period; // 대출기간

    @Column(name = "LOAN_LINE")
    private String loanLine; // 해지 환급금의 50%~95%까지 여기서 숫자를 스트링으로 "50 95" 보낼예정

    @Column(name = "TAG")
    private String tag; // ex) 주부, 프리랜서, 모바일, 1금융권
}
// 대출상품 : 대출한도, 금리, 대출 기간, 상품명, 상품유형, 가입요건