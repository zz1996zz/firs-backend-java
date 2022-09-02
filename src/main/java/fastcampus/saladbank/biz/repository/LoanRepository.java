package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = "SELECT l.loan_id, l.createdDate, l.modifiedDate, l.product_type, l.loan_name, l.loan_company, l.credit_line, l.rate, l.prime_rate, l.period, l.loan_line, l.tag, l.img FROM Loan l WHERE l.loan_name LIKE %:keyword% OR l.loan_company LIKE %:keyword% OR l.tag LIKE %:keyword%", nativeQuery = true)
    List<Loan> findAllByLoanInfo(@Param("keyword") String keyword);

    @Query(value = "SELECT l.loan_id, l.createdDate, l.modifiedDate, l.product_type, l.loan_name, l.loan_company, l.credit_line, l.rate, l.prime_rate, l.period, l.loan_line, l.tag, l.img FROM Loan l", nativeQuery = true)
    List<Loan> findLoanAll();
}
