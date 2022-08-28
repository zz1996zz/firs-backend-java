package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.config.auth.PrincipalDetails;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @DeleteMapping("/logout")
    public void logout() {

    }

    @PostMapping("/register")
    public ResponseEntity registerMember(@RequestBody MemberForm reqMemberForm) {
        memberService.registerMember(reqMemberForm);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal : "+principal.getMember().getId());
        System.out.println("principal : "+principal.getMember().getUsername());
        System.out.println("principal : "+principal.getMember().getPassword());

        return "<h1>user</h1>";
    }

}
