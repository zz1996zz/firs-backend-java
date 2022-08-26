package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Loan,Long> {
}
