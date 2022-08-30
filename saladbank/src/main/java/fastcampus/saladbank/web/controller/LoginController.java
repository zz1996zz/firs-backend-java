package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.domain.Member;
import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.config.auth.PrincipalDetails;
import fastcampus.saladbank.config.jwt.JwtProperties;
import fastcampus.saladbank.web.ImageToBase64Encoder;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/do-logout")
    public ResponseEntity logoutMember() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(JwtProperties.HEADER_STRING, "logout");
        return new ResponseEntity("로그아웃 완료", headers, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity registerMember(@RequestBody MemberForm reqMemberForm) {
        memberService.registerMember(reqMemberForm);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/duplicate")
    public ResponseEntity<String> duplicateMemberId(@RequestBody String username) {
        if (memberService.isRegisterMember(username)) {
            String status = "true";
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        String status = "false";
        return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/test")
    public void test(Authentication authentication) throws IOException {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String username = principal.getMember().getUsername();

        ImageToBase64Encoder encoder = new ImageToBase64Encoder();
        String encodedString = encoder.imageToBase64("국민");
        log.info("encodedString={}", encodedString);

        Member member = memberRepository.findByUsername(memberForm.getUsername()).orElseThrow(() -> new RuntimeException("오류발생"));
        log.info("member={}", member.getUsername());
    }
}
