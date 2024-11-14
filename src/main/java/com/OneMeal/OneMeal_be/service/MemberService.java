package com.OneMeal.OneMeal_be.service;

import com.OneMeal.OneMeal_be.dto.MemberDTO;
import com.OneMeal.OneMeal_be.repository.MemberRepository;
import entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDTO getMemberByUsername(String username) {
        Member member = memberRepository.findByUsername(username);

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUsername(member.getUsername());
        memberDTO.setName(member.getName());
        memberDTO.setPhoneNumber(member.getPhoneNumber());
        memberDTO.setBirthDate(member.getBirthDate());
        memberDTO.setGender(member.getGender());
        memberDTO.setAddress(member.getAddress());
        memberDTO.setLoginType(member.getLoginType());

        return memberDTO;
    }
}