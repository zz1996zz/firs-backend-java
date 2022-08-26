package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    void deleteAllByCartId(long id);

    List<CartItem> findAllByCart(Cart cart);
}
