package com.bng.ddaja.common.config.resolver;

import javax.servlet.http.HttpServletRequest;

import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.enums.TokenType;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.common.util.CookieUtil;
import com.bng.ddaja.tokens.service.TokenService;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JWTArgumentResolver implements HandlerMethodArgumentResolver {
    
    private TokenService tokenService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return CommonJWT.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
                HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
                return tokenService.getCommonJWTByJWT(TokenType.ACCESS.getTokenInCookie(request));
    }
}
