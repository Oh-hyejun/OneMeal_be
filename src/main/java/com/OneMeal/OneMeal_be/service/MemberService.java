package com.OneMeal.OneMeal_be.service;

import com.OneMeal.OneMeal_be.dto.MemberDTO;
import com.OneMeal.OneMeal_be.repository.MemberRepository;
import com.OneMeal.OneMeal_be.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDTO getMemberByUsername(String username) {
        Member member = memberRepository.findByUsername(username);

        MemberDTO memberInfo = new MemberDTO(member);

        return memberInfo;
    }

    public boolean isUsernameAvailable(String username) {
        return !memberRepository.existsByUsername(username);
    }

    public void signUp(MemberDTO memberDTO) {

    }
}