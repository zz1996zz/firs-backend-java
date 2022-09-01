package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByMember(Member member);
}
