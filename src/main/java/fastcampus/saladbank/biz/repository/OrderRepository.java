package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
