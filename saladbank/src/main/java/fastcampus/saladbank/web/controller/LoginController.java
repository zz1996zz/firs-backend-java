package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    // 이 컨트롤러 생략해도 될까?
    @PostMapping("/login")
    public void login() {

    }

    @DeleteMapping("/logout")
    public void logout() {

    }

    @PostMapping("/register")
    public ResponseEntity registerMember(@RequestBody MemberForm reqMemberForm) {
        memberService.registerMember(reqMemberForm);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
