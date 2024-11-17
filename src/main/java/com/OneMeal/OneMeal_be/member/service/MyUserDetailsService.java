package com.OneMeal.OneMeal_be.member.service;

import com.OneMeal.OneMeal_be.member.entity.Member;
import com.OneMeal.OneMeal_be.member.repository.MemberRepository;
import com.OneMeal.OneMeal_be.member.security.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var result = memberRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("아이디를 찾을 수 없습니다.");
        }
        Member member = result.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("일반유저"));

        CustomUser user = new CustomUser(member.getUsername(), member.getPassword(), authorities);

        user.setName(member.getName());
        user.setId(member.getId());

        return user;
    }
}
