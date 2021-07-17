package com.bng.ddaja.common.auth;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthJWT {
    private final String secretKey = "Gil11ogG2200";

    public static void main(String[] args) throws UnsupportedEncodingException {
        AuthJWT authJWT = new AuthJWT();

        String jwt = authJWT.createToken();

        Map<String, Object> claimMap = authJWT.verifyJWT(jwt);
        // 토큰 만료 or 검증 실패 시 null
        System.out.println(claimMap);
    }

    public String createToken() {

        // Header 설정
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        // payload 설정
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("iss", "gillog");
        payloads.put("aud", "all");
        payloads.put("data", "Gillog JWT");

        Long expiredTime = 1000 * 60L * 60L * 2L;

        Date expDate = new Date();
        expDate.setTime(expDate.getTime() + expiredTime);

        return Jwts.builder().setHeader(headers) // Headers 설정
                .setClaims(payloads) // Claims 설정
                .setSubject("study") // 토큰 용도
                .setExpiration(expDate) // 토큰 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // HS256과 Key로 Sign
                .compact(); // 토큰 생성
    }

    public Map<String, Object> verifyJWT(String jwt) throws UnsupportedEncodingException {
        Map<String, Object> claimMap = null;
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(secretKey.getBytes()) // Secreat Key로 Signature 설정
                    .build().parseClaimsJws(jwt) // 파싱 실패 시 에러 발생
                    .getBody();

            claimMap = claims;

            // Claim 사용 법 일반 Map 형태 처럼 사용
            Date expiration = claims.get("exp", Date.class);
            String data = claims.get("iss", String.class);

        } catch (ExpiredJwtException e) { // 토큰 만료
            System.out.println(e);
        } catch (Exception e) { // 그 외 에러
            System.out.println(e);
        }
        return claimMap;
    }
}