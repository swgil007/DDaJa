package com.bng.ddaja.common.config.interceptor;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bng.ddaja.common.enums.AuthRequiredURLs;
import com.bng.ddaja.common.enums.SetCookieURLs;
import com.bng.ddaja.tokens.service.TokenService;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {
    
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception  {
        if(request.getMethod().equals("OPTIONS")) return true;
        boolean isAuthRequiredURL = Arrays.stream(AuthRequiredURLs.values()).anyMatch(e-> request.getRequestURI().contains(e.getName()));
        if(!isAuthRequiredURL) return true;
        String jwt = request.getHeader("Authorization");
        if(jwt == null) throw new AuthenticationException("JWT is Required");
        return tokenService.isValidatedJWT(jwt);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        boolean isSetCookieURL = Arrays.stream(SetCookieURLs.values()).anyMatch(e-> request.getRequestURI().contains(e.getName()));
        if(!isSetCookieURL) return;
        log.info("afterCompletion arrived");
        log.info("request == {}", request);
        log.info("response.getCharacterEncoding() == {}", response.getCharacterEncoding());
        log.info("response.getContentType() == {}", response.getContentType());
        log.info("response.getOutputStream() == {}", response.getOutputStream());
        log.info("handler == {}", handler);
        log.info("exception == {}", ex);
        String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        log.info("test ==={}", test);
    }
}