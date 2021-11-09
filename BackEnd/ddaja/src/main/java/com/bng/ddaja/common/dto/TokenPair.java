package com.bng.ddaja.common.dto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.bng.ddaja.common.config.exception.exception.CookieNotFoundException;
import com.bng.ddaja.common.enums.TokenType;

import lombok.Getter;

@Getter
public class TokenPair {
    private String accessToken;
    private Cookie accessCookie;
    private String refreshToken;
    private Cookie refreshCookie;

    public TokenPair(CommonJWT commonJWT, String secretKey) {
        accessToken = TokenType.ACCESS.createToken(commonJWT, secretKey);
        commonJWT.setJwt(accessToken);
        refreshToken = TokenType.REFRESH.createToken(commonJWT, secretKey);
        accessCookie = new Cookie(TokenType.ACCESS.getName(), accessToken);
        TokenType.ACCESS.setCookieConfigure(accessCookie);
        refreshCookie = new Cookie(TokenType.REFRESH.getName(), refreshToken);
        TokenType.REFRESH.setCookieConfigure(refreshCookie);
    }

    public void setCookie(HttpServletResponse response) {
        if (accessCookie == null || refreshCookie == null)
            throw new CookieNotFoundException("설정할 쿠키 정보가 존재하지 않습니다.");
        response.addCookie(accessCookie);
        response.addCookie(refreshCookie);
    }
}
