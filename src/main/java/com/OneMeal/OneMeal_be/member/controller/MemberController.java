package com.OneMeal.OneMeal_be.member.controller;

import com.OneMeal.OneMeal_be.member.dto.MemberDTO;
import com.OneMeal.OneMeal_be.member.dto.SignUpDTO;
import com.OneMeal.OneMeal_be.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/member/{username}")
    public MemberDTO getMember(@PathVariable String username) {
        return memberService.getMemberByUsername(username);
    }

    @GetMapping("/api/member/username/{username}")
    public ResponseEntity<?> checkUsernameAvailability(@PathVariable String username) {
        boolean isUsernameAvailable = memberService.isUsernameAvailable(username);
        if (isUsernameAvailable) {
            return ResponseEntity.ok("사용가능한 아이디.");
        } else {
            return ResponseEntity.status(400).body("중복된 아이디");
        }
    }

    @PostMapping("/api/member/signup/")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO) {

        memberService.signUp(signUpDTO);

        return ResponseEntity.ok("회원가입 성공");
    }
}
