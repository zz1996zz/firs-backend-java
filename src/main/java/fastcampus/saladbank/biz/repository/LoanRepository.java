package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByLoanNameOrLoanCompanyOrTag(String keyword);
}
