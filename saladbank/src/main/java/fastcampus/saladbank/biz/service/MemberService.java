package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CartRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final CartRepository cartRepository;

    @Transactional
    public void registerMember(MemberForm memberForm) {
        String encodePS = bCryptPasswordEncoder.encode(memberForm.getPassword());
        memberForm.setPassword(encodePS);
        Member member = memberForm.toEntity();
        memberRepository.save(member);

        Cart cart = new Cart(member);
        cartRepository.save(cart);
    }

    public MemberForm getMemberInfo(String username) {
        Member findMember = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("멤버를 찾지 못했습니다."));
        MemberForm memberForm = new MemberForm();
        memberForm.toMemberForm(findMember);
        return memberForm;
    }

    @Transactional
    public void editMemberInfo(MemberForm memberForm) {
        Member findMember = memberRepository.findByUsername(memberForm.getUsername()).orElseThrow(() -> new RuntimeException("멤버를 찾지 못했습니다."));
        findMember.updateMember(memberForm);
        log.info("findMember={}", findMember.getAge());
        log.info("findMember={}", findMember.getGender());
        log.info("findMember={}", findMember.getHobby());
        log.info("findMember={}", findMember.getIncome());
    }

    public boolean isRegisterMember(String username) {
        Member findMember = memberRepository.findByUsername(username).orElse(null);
        if (findMember != null) {
            return true;
        }
        return false;
    }

    public void registerMemberInfo(MemberForm memberForm) {
        // username으로 사용자를 찾고 사용자의 정보를 추가한다.
    }
}
