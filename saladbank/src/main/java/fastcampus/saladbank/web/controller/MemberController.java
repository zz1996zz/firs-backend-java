package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void editMemberForm() {
        // 회원정보 수정화면 보여주기 프론트에 회원의 정보를 보내준다.
    }

    @PostMapping("/edit")
    public void editMember() {
        // 수정된 회원 정보를 업데이트
    }

    @GetMapping("/recommendation")
    public void recommendProduct() {
        // 추천 상품 보여주기
    }
}
