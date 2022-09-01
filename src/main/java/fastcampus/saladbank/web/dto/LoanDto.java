package fastcampus.saladbank.web.dto;

import fastcampus.saladbank.biz.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LoanDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private String productType;
        private String loanName;
        private String loanCompany;
        private String creditLine;
        private String rate;
        private Boolean primeRate;
        private int period;
        private String loanLine;
        private String tag;

        public static LoanDto.Response of(Loan loan) {
            return Response.builder()
                    .productType(loan.getProductType())
                    .loanName(loan.getLoanName())
                    .loanCompany(loan.getLoanCompany())
                    .creditLine(loan.getCreditLine())
                    .rate(loan.getRate())
                    .primeRate(loan.getPrimeRate())
                    .period(loan.getPeriod())
                    .loanLine(loan.getLoanLine())
                    .tag(loan.getTag())
                    .build();
        }
    }
}