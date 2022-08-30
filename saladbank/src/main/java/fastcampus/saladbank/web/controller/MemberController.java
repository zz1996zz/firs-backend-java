package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/my-page")
    public void myPage() {
        // 신청중인 상품과 신청 완료된 상품 가져오기
    }

    @GetMapping("/edit")
    public MemberForm getMemberForm(@Login MemberForm memberForm) {
        String username = memberForm.getUsername();
        MemberForm memberInfo = memberService.getMemberInfo(username);
        return memberInfo;
    }

    @PutMapping ("/edit")
    public void editMember(@Login MemberForm memberForm) {
        // 수정된 회원 정보를 업데이트
    }

    @GetMapping("/recommendation")
    public void recommendProduct() {
        // 추천 상품 보여주기
    }
}
