package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <Cart,Long> {
}
