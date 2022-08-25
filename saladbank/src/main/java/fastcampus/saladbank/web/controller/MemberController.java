package fastcampus.saladbank.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    @DeleteMapping
    public void withdrawal() {

    }

    @PostMapping("/detail")
    public void registerMemberInfo() {

    }

    @GetMapping("/mypage")
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
