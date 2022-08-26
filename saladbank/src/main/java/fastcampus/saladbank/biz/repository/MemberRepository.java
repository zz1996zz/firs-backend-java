package fastcampus.saladbank.biz.repository;

import fastcampus.saladbank.biz.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);
}
