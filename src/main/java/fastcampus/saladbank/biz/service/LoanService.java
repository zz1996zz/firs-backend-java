package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoanService {

    private final LoanRepository loanRepository;

    public List getLoanList() {
        return loanRepository.findLoanAll();
    }

    public Loan getLoan(long loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다."));
    }
}
