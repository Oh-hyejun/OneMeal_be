package com.OneMeal.OneMeal_be.member.dto;

import com.OneMeal.OneMeal_be.member.entity.Member;
import lombok.Data;

import java.sql.Date;

@Data
public class MemberDTO {
    private String username;
    private String name;
    private String phoneNumber;
    private Date birthDate;
    private Character gender;
    private Integer zoneCode;
    private String address;
    private String detailAddress;
    private String loginType;

    public MemberDTO(Member member) {
        this.username = member.getUsername();
        this.name = member.getName();
        this.phoneNumber = member.getPhone_number();
        this.birthDate = member.getBirth_date();
        this.gender = member.getGender();
        this.zoneCode = member.getZone_code();
        this.address = member.getAddress();
        this.detailAddress = member.getDetail_address();
        this.loginType = member.getLogin_type();
    }
}
