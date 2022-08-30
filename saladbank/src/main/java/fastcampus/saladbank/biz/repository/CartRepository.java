package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository <Cart,Long> {

Cart findByMember(Optional<Member> member);
}
