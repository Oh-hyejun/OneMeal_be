package com.OneMeal.OneMeal_be.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuthService {

    @Value("${google.client-id}")
    private String googleClientId;

    @Value("${google.client-secret}")
    private String googleClientSecret;

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    @Value("${kakao.client-secret}")
    private String kakaoClientSecret;

    @Value("${google.redirect-uri}")
    private String googleRedirectUri;

    @Value("${kakao.redirect-url}")
    private String kakaoRedirectUri;

    public String exchangeCodeForAccessToken(String provider, String code) {
        String tokenEndpoint = getTokenEndpoint(provider);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", getClientId(provider));
        params.add("client_secret", getClientSecret(provider));
        params.add("redirect_uri", getRedirectUri(provider));
        params.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.exchange(tokenEndpoint, HttpMethod.POST, request, Map.class);

        return (String) response.getBody().get("access_token");
    }

    private String getTokenEndpoint(String provider) {
        switch (provider.toUpperCase()) {
            case "GOOGLE":
                return "https://oauth2.googleapis.com/token";
            case "KAKAO":
                return "https://kauth.kakao.com/oauth/token";
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }

    private String getClientId(String provider) {
        switch (provider.toUpperCase()) {
            case "GOOGLE":
                return googleClientId;
            case "KAKAO":
                return kakaoClientId;
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }

    private String getClientSecret(String provider) {
        switch (provider.toUpperCase()) {
            case "GOOGLE":
                return googleClientSecret;
            case "KAKAO":
                return kakaoClientSecret;
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }

    private String getRedirectUri(String provider) {
        switch (provider.toUpperCase()) {
            case "GOOGLE":
                return googleRedirectUri;
            case "KAKAO":
                return kakaoRedirectUri;
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }

}
