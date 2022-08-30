package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.*;
import fastcampus.saladbank.biz.repository.*;
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
    private final FavoriteRepository favoriteRepository;

    @Transactional
    public void registerMember(MemberForm memberForm) {
        String encodePS = bCryptPasswordEncoder.encode(memberForm.getPassword());
        memberForm.setPassword(encodePS);
        Member member = memberForm.toEntity();
        memberRepository.save(member);

        Cart cart = new Cart(member);

        Favorite favorite = new Favorite(member);

        cartRepository.save(cart);
        favoriteRepository.save(favorite);


    }

    public MemberForm getMemberInfo(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("멤버를 찾지 못했습니다."));
        MemberForm memberForm = new MemberForm();
        memberForm.toMemberForm(member);
        return memberForm;
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
