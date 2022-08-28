package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity registerMember(@RequestBody MemberForm reqMemberForm) {
        memberService.registerMember(reqMemberForm);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/duplicate")
    public String duplicateMemberId(@RequestBody String username) {
        if (memberService.isRegisterMember(username)) {
            return "true";
        }
        return "false";
    }
}
