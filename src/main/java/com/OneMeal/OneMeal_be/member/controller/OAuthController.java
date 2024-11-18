package com.OneMeal.OneMeal_be.member.controller;


import com.OneMeal.OneMeal_be.member.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/oauth")
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService oAuthService;

    @PostMapping("/login/{provider}")
    public ResponseEntity<Map<String, String>> login(
            @PathVariable String provider,
            @RequestBody Map<String, String> body
            ) {
        String code = body.get("code");
        String accessToken;

        accessToken = oAuthService.exchangeCodeForAccessToken(provider, code);

        return ResponseEntity.ok(Map.of("access_token", accessToken));
    }

}
