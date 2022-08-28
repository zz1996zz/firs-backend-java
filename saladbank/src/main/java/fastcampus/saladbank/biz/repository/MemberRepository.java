package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);
    boolean existsByUsername(String username);
}
