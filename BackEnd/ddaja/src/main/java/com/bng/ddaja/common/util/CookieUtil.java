package com.bng.ddaja.common.util;

import java.util.Arrays;
import java.util.Optional;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bng.ddaja.common.config.exception.exception.CookieNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CookieUtil {
    private static final int MAX_AGE_TOKEN = 7;
    private static final int ONE_DAY = 24 * 60 * 60;
    
    public static String getTokenInCookie(HttpServletRequest request) throws AuthenticationException {
        Cookie tokenCookie = getCookie(request, Constants.ACCESS_TOKEN);
        if(tokenCookie == null) throw new AuthenticationException("Token 정보가 없습니다.");
        return tokenCookie.getValue();
    }
    
    public static void setJwtCookieInResponse(HttpServletResponse response, String jwt) {
        Cookie cookie = new Cookie(Constants.ACCESS_TOKEN, jwt);
        cookie.setMaxAge(MAX_AGE_TOKEN * ONE_DAY);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie result = null;
        try {
            result = findCookie(request, name);
        } catch(CookieNotFoundException e) {
            log.error("Cookie 가져오기에 실패 하였습니다.", e);
        }
        return result;
    }
    
    private static Cookie findCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Optional<Cookie> cookie = Arrays.stream(cookies).filter(e -> e.getName().equals(name)).findAny();
        if(!cookie.isPresent()) throw new CookieNotFoundException();
        return cookie.get();
    }
}
