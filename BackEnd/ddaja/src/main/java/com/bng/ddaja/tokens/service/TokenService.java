package com.bng.ddaja.tokens.service;

import java.util.Optional;

import javax.security.sasl.AuthenticationException;

import com.bng.ddaja.admin.dto.AdminDTO;
import com.bng.ddaja.admin.repository.AdminRepository;
import com.bng.ddaja.common.config.PublicKeyConfig;
import com.bng.ddaja.common.config.exception.exception.MemberNotFoundException;
import com.bng.ddaja.common.domain.Admin;
import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.dto.CommonToken;
import com.bng.ddaja.common.dto.TokenPair;
import com.bng.ddaja.tokens.dto.TokenDTO;
import com.bng.ddaja.tokens.repository.TokenRepository;
import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.repository.UserRepository;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class TokenService {
    private PublicKeyConfig publicKeyConfig;
    private TokenRepository tokenRepository;
    private UserRepository userRepository;
    private AdminRepository adminRepository;

    private <U extends CommonToken> CommonJWT getCommonJWT(U u) {
        if (u.getClass().isAssignableFrom(UserDTO.class)) {
            Optional<User> optionalUser = userRepository.findById(u.getId());
            if (!optionalUser.isPresent())
                throw new MemberNotFoundException("해당 사용자 계정이 확인되지 않습니다.");
            CommonJWT result = new CommonJWT(new UserDTO(optionalUser.get()));
            return result;
        }
        Optional<Admin> optionalAdmin = adminRepository.findById(u.getId());
        if (!optionalAdmin.isPresent())
            throw new MemberNotFoundException("해당 관리자 계정이 확인되지 않습니다.");
        CommonJWT result = new CommonJWT(new AdminDTO(optionalAdmin.get()));
        return result;
    }

    public TokenPair getTokenPair(CommonToken commonToken) {
        return new TokenPair(getCommonJWT(commonToken), publicKeyConfig.getPublicKey());
    }

    public CommonJWT getCommonJWTByJWT(String jwt) {
        if(jwt == null) return new CommonJWT(false);
        return new CommonJWT(jwt, parseJWT(jwt));
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

    private Claims parseJWT(String jwt) {
        if(!isValidatedJWT(jwt)) return null;
        return  Jwts.parserBuilder()
                    .setSigningKey(publicKeyConfig.getSecretKey())
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
    }

    public TokenDTO getTokenByClientID(String clientID) {
        return new TokenDTO(tokenRepository.findByClientID(clientID));
    }
}
