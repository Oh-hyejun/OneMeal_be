package com.OneMeal.OneMeal_be.member.security;

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

    public static String createToken(Authentication auth) {

        CustomUser user = (CustomUser) auth.getPrincipal();

         String authorieties =  auth.getAuthorities().stream().map(
                a -> a.getAuthority()
        ).collect(Collectors.joining(","));

        String jwt = Jwts.builder()
                .claim("id", user.getId())
                .claim("name", user.getUsername())
                .claim("authorieties", authorieties)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
        return jwt;
    }

    public static Claims extractToken(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build()
                .parseSignedClaims(token).getPayload();
        return claims;
    }

}