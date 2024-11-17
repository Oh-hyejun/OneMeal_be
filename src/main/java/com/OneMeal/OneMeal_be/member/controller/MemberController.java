package com.OneMeal.OneMeal_be.member.controller;

import com.OneMeal.OneMeal_be.member.JwtUtill;
import com.OneMeal.OneMeal_be.member.dto.MemberDTO;
import com.OneMeal.OneMeal_be.member.dto.SignUpDTO;
import com.OneMeal.OneMeal_be.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

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
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDTO signUpDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        memberService.signUp(signUpDTO);

        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/api/member/login")
    public String login(@RequestBody Map<String, String> loginInfo) {

        var authToken = new UsernamePasswordAuthenticationToken(
                loginInfo.get("username"), loginInfo.get("password")
        );
        var auth = authenticationManagerBuilder.getObject().authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtUtill.createToken(SecurityContextHolder.getContext().getAuthentication());

        return jwt;
    }

}
