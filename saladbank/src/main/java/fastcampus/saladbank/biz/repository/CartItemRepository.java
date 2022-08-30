package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findAllByCart(Cart cart);

    void deleteAllByCart(Cart cart);

}
