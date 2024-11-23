package com.OneMeal.OneMeal_be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/login")
    String login() {
        return "login.html";
    }

    @GetMapping("/signUp")
    String signUp() {
        return "signUp.html";
    }

    @GetMapping("/home")
    String home() {
        return "home.html";
    }

    @GetMapping("/post")
    String post() { return "post.html"; }
}
