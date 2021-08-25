package com.bng.ddaja.common.util;

import java.util.Date;

import com.bng.ddaja.common.config.PublicKeyConfig;
import com.bng.ddaja.common.dto.CommonJWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JWTUtil {
    private final PublicKeyConfig publicKeyConfig;

    public String createJWT(CommonJWT commonJWT) {
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

    public boolean isValidatedJWT(String jwt) {
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

    public Claims parseJWT(String jwt) {
        if(!isValidatedJWT(jwt)) return null;
        return  Jwts.parserBuilder()
                    .setSigningKey(publicKeyConfig.getSecretKey())
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
    }
}
