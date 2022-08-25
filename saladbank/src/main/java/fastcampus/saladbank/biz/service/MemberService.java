package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void registerMember(MemberForm memberForm) {
        Member member = Member.builder()
                .username(memberForm.getUsername())
                .password(bCryptPasswordEncoder.encode(memberForm.getPassword()))
                .name(memberForm.getName())
                .mobileCarrier(memberForm.getMobileCarrier())
                .phone(memberForm.getPhone())
                .build();
        memberRepository.save(member);
    }

    public void registerMemberInfo(MemberForm memberForm) {
        // username으로 사용자를 찾고 사용자의 정보를 추가한다.
    }
}
