package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Loan;
import lombok.Data;

@Data
public class LoanForm {

    private String productType;
    private String loanName;
    private String loanCompany;
    private String creditLine;
    private String rate;
    private boolean primeRate;
    private int period;
    private String loanLine;
    private String tag;

    public Loan toEntity() {
        return new Loan(productType, loanName, loanCompany, creditLine, rate, primeRate, period, loanLine, tag);
    }
}
