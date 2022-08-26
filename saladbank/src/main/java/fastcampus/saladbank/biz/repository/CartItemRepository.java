package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    void deleteAllByCartId(long id);
}
