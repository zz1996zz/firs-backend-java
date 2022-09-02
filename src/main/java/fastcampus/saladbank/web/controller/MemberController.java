package fastcampus.saladbank.web.controller;

import fastcampus.saladbank.biz.service.MemberService;
import fastcampus.saladbank.biz.service.OrderService;
import fastcampus.saladbank.web.argumentresolver.Login;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final OrderService orderService;

    @GetMapping("/my-page")
    public ResponseEntity myPage(@Login MemberForm memberForm) {
        String orderList = orderService.getOrderList(memberForm.getUsername());
        log.info("orderList={}", orderList);
        return new ResponseEntity(orderList, HttpStatus.OK);
    }

    @GetMapping("/edit")
    public MemberForm getMember(@Login MemberForm memberForm) {
        String username = memberForm.getUsername();
        MemberForm memberInfo = memberService.getMemberInfo(username);
        return memberInfo;
    }

    @PutMapping ("/edit")
    public void editMember(@RequestBody MemberForm reqMemberForm) {
        memberService.editMemberInfo(reqMemberForm);
    }

    @GetMapping("/recommendation")
    public ResponseEntity recommendProduct(@Login MemberForm memberForm) {
        String json = memberService.makeJson(memberForm.getUsername());
        return new ResponseEntity(json, HttpStatus.OK);
    }
}
