package fastcampus.saladbank.biz.service;

import fastcampus.saladbank.biz.domain.Cart;
import fastcampus.saladbank.biz.domain.Favorite;
import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.CartRepository;
import fastcampus.saladbank.biz.repository.FavoriteRepository;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.web.RecommendationProduct;
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

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final FavoriteRepository favoriteRepository;
    private final RecommendationProduct recommendationProduct;

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

    public String makeJson(String username) {
        StringBuilder sb = new StringBuilder();
        String rateAndLimit = recommendationProduct.setInterestRateAndLimit(username);
        String jsonCard = recommendationProduct.getRecommendationCard(username);
        String jsonLoan = recommendationProduct.getRecommendationLoan(username);

        sb.append("{\n\"userInfo\" : " + "\"" + rateAndLimit + "\"" + ",\n");
        sb.append("\"cardList\" : " + jsonCard + ",\n");
        sb.append("\"loanList\" : " + jsonLoan + "\n}");

        return sb.toString();
    }

    public boolean isRegisterMember(String username) {
        Member findMember = memberRepository.findByUsername(username).orElse(null);
        if (findMember != null) {
            return true;
        }
        return false;
    }
}
