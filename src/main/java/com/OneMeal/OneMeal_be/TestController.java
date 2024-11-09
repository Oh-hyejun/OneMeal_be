package com.OneMeal.OneMeal_be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/home")
    public String home() {
        return "home.html";
    }

    @GetMapping("/login")
    public String login() {

        return "login.html";
    }


}