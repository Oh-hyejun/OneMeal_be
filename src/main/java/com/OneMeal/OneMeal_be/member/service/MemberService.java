package com.OneMeal.OneMeal_be.member.service;

import com.OneMeal.OneMeal_be.member.dto.MemberDTO;
import com.OneMeal.OneMeal_be.member.dto.SignUpDTO;
import com.OneMeal.OneMeal_be.member.repository.MemberRepository;
import com.OneMeal.OneMeal_be.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDTO getMemberByUsername(String username) {
        Optional<Member> member = memberRepository.findByUsername(username);

        MemberDTO memberInfo = new MemberDTO(member.get());

        return memberInfo;
    }

    public boolean isUsernameAvailable(String username) {
        return !memberRepository.existsByUsername(username);
    }

    public void signUp(SignUpDTO signUpDTO) {
        Member member = new Member();



        member.setUsername(signUpDTO.getUsername());
        member.setName(signUpDTO.getName());
        member.setPhone_number(signUpDTO.getPhoneNumber());
        member.setBirth_date(signUpDTO.getBirthDate());
        member.setGender(signUpDTO.getGender());
        member.setZone_code(signUpDTO.getZoneCode());
        member.setAddress(signUpDTO.getAddress());
        member.setDetail_address(signUpDTO.getDetailAddress());
        member.setLogin_type(signUpDTO.getLoginType());

        member.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));

        memberRepository.save(member);
    }
}