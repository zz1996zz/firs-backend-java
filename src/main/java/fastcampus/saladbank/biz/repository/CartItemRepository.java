package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Card;
import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.CartItem;
import fastcampus.saladbank.biz.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findAllByCart(Cart cart);

    void deleteAllByCart(Cart cart);

    CartItem findByCard(Card card);

    CartItem findByCardAndCart(Card card, Cart cart);

    CartItem findByLoanAndCart(Loan loan, Cart cart);
}
