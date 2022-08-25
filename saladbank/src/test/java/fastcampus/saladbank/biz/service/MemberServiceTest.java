package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void registerMember() {
        //given
        Member member = Member.builder()
                .username("test")
                .password(bCryptPasswordEncoder.encode("test1234"))
                .name("테스터")
                .mobileCarrier("SK")
                .phone("01011112222")
                .build();

        //when
        Member result = memberRepository.save(member);

        //then
        assertThat(result).isEqualTo(member);
    }
}