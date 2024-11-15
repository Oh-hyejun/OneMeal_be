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

        MemberDTO memberInfo = new MemberDTO();
        memberInfo.setUsername(member.getUsername());
        memberInfo.setName(member.getName());
        memberInfo.setPhoneNumber(member.getPhone_number());
        memberInfo.setBirthDate(member.getBirth_date());
        memberInfo.setGender(member.getGender());
        memberInfo.setAddress(member.getAddress());
        memberInfo.setLoginType(member.getLogin_type());
        memberInfo.setZoneCode(member.getZone_code());
        memberInfo.setDetailAddress(member.getDetail_address());

        return memberInfo;
    }
}