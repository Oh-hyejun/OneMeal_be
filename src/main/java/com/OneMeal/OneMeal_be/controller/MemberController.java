package com.OneMeal.OneMeal_be.controller;

import com.OneMeal.OneMeal_be.dto.MemberDTO;
import com.OneMeal.OneMeal_be.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("중복된 아이디");
        }
    }

    @PostMapping("/api/signup/")
    public ResponseEntity<?> signUp(@RequestBody MemberDTO memberDTO) {

        memberService.signUp(memberDTO);

        return ResponseEntity.ok("회원가입 성공");
    }
}
