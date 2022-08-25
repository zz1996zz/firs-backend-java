package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @DeleteMapping
    public void withdrawal() {

    }

    @PostMapping("/detail")
    public void registerMemberInfo(@RequestBody MemberForm reqMemberForm) {
        // 로그인 한 다음에 사용자의 정보가 없으면 정보 등록 페이지로 이동 시키게 만들어야한다.
        // 사용자에게 받은 jwt를 복호화해서 안에 username으로 사용자를 찾아 정보를 추가하게 한다.
        memberService.registerMemberInfo(reqMemberForm);
    }

    @GetMapping("/my-page")
    public void myPage() {

    }

    @GetMapping("/edit")
    public void editMemberForm() {

    }

    @PostMapping("/edit")
    public void editMember() {

    }

    @GetMapping("/recommendation")
    public void recommendProduct() {

    }
}
