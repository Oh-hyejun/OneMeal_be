package com.OneMeal.OneMeal_be.controller;

import com.OneMeal.OneMeal_be.dto.MemberDTO;
import com.OneMeal.OneMeal_be.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/member/{username}")
    public MemberDTO getMember(@PathVariable String username) {
        return memberService.getMemberByUsername(username);
    }
}
