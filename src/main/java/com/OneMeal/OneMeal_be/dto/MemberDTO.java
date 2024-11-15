package com.OneMeal.OneMeal_be.dto;

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
}
