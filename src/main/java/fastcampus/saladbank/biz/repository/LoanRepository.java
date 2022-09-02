package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findAllByLoanNameContainsOrLoanCompanyContainsOrTagContains(String keyword1, String keyword2, String keyword3);
}
