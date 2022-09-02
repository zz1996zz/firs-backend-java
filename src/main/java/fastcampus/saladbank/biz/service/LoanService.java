package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Loan;
import fastcampus.saladbank.biz.repository.LoanRepository;
import fastcampus.saladbank.web.dto.LoanForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoanService {

    private final LoanRepository loanRepository;

    public List getLoanList() {
        List<LoanForm> loanForms = new ArrayList<>();
        List<Loan> loanList = loanRepository.findAll();
        for (Loan loan : loanList) {
            LoanForm loanForm = new LoanForm(loan);
            loanForms.add(loanForm);
        }
        return loanForms;
    }

    public Loan getLoan(long loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("해당 상품이 없습니다."));
    }
}
