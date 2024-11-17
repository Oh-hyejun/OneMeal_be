package com.OneMeal.OneMeal_be.member;

import com.OneMeal.OneMeal_be.member.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtill {

    static final SecretKey key =
            Keys.hmacShaKeyFor(Decoders.BASE64.decode(
                    "OneMealpassword0303OneMealpassword0303OneMealpassword0303OneMealpassword0303"
            ));

    // JWT 만들어주는 함수
    public static String createToken(Authentication auth) {

        Member user = (Member) auth.getPrincipal();

         String authorieties =  auth.getAuthorities().stream().map(
                a -> a.getAuthority()
        ).collect(Collectors.joining(","));

        String jwt = Jwts.builder()
                .claim("username", user.getUsername())
                .claim("name", user.getName())
                .claim("authorieties", authorieties)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 360000))
                .signWith(key)
                .compact();
        return jwt;
    }

    // JWT 까주는 함수
    public static Claims extractToken(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build()
                .parseSignedClaims(token).getPayload();
        return claims;
    }

}