package fastcampus.saladbank.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    @PostMapping("/login")
    public void login() {

    }

    @DeleteMapping("/logout")
    public void logout() {

    }

    @PostMapping("/register")
    public void registerMember() {

    }
}
