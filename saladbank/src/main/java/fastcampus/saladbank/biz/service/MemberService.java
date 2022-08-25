package fastcampus.saladbank.biz.service;

public class MemberService {

import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void registerMember(MemberForm memberForm) {
        Member member = Member.builder()
                .username(memberForm.getUsername())
                .password(bCryptPasswordEncoder.encode(memberForm.getPassword()))
                .name(memberForm.getName())
                .mobileCarrier(memberForm.getMobileCarrier())
                .phone(memberForm.getPhone())
                .build();
        Member result = memberRepository.save(member);
        log.info("result = {}", result.toString());
    }

    public void registerMemberInfo(MemberForm memberForm) {
        // username으로 사용자를 찾고 사용자의 정보를 추가한다.
    }
}
