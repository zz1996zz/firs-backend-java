package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Loan;
import lombok.Data;

@Data
public class LoanForm {
    private long loanId;
    private String productType;
    private String loanName;
    private String loanCompany;
    private String creditLine;
    private String rate;
    private boolean primeRate;
    private int period;
    private String loanLine;
    private String tag;
    private String img;

    public LoanForm(Loan loan) {
        this.loanId = loan.getLoanId();
        this.productType = loan.getProductType();
        this.loanName = loan.getLoanName();
        this.loanCompany = loan.getLoanCompany();
        this.creditLine = loan.getCreditLine();
        this.rate = loan.getRate();
        this.primeRate = loan.getPrimeRate();
        this.period = loan.getPeriod();
        this.loanLine = loan.getLoanLine();
        this.tag = loan.getTag();
        this.img = loan.getImg();
    }
}
