package com.bng.ddaja.tokens.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import com.bng.ddaja.common.config.PublicKeyConfig;
import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.common.util.DateUtil;
import com.bng.ddaja.tokens.repository.TokensRepository;
import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.service.UsersService;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class TokensService {
    private PublicKeyConfig publicKeyConfig;
    private TokensRepository tokensRepository;
    private UsersService usersService;

    public CommonJWT getCommonJWTByUserDTO(UserDTO userDTO) {
        return null;
    }

    private String createJWT(CommonJWT commonJWT) {
        Date now = new Date();     
        return Jwts.builder()
                    .setSubject(commonJWT.getUserName())
                    .claim(Constants.CLAIMS_ROLE, commonJWT.getRole())
                    .claim(Constants.CLAIMS_USER_NAME, commonJWT.getUserName())
                    .claim(Constants.CLAIMS_USER_ID, commonJWT.getUserID())
                    .claim(Constants.CLAIMS_ID, commonJWT.getId())
                    .setIssuedAt(now)
                    .setExpiration(DateUtil.addHours(now, 12))
                    .signWith(publicKeyConfig.getSecretKey())
                    .compact();
    }

    private boolean isValidatedJWT(String jwt) {
        if(jwt == null) return false;
        try {
            Jwts.parserBuilder()
                .setSigningKey(publicKeyConfig.getSecretKey())
                .build()
                .parse(jwt);
                return true;
        } catch(JwtException e) {
            throw e;
        }
    }

    private Claims parseJWT(String jwt) {
        if(!isValidatedJWT(jwt)) return null;
        return  Jwts.parserBuilder()
                    .setSigningKey(publicKeyConfig.getSecretKey())
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
    }
}
