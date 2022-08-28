package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CartRepository;
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

    public boolean isRegisterMember(String username) {
        boolean isMember = memberRepository.existsByUsername(username);
        if (isMember) {
            return true;
        }
        return false;
    }

    public void registerMemberInfo(MemberForm memberForm) {
        // username으로 사용자를 찾고 사용자의 정보를 추가한다.
    }
}
