package com.bng.ddaja.tokens.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;
import javax.security.sasl.AuthenticationException;

import com.bng.ddaja.admin.dto.AdminDTO;
import com.bng.ddaja.admin.repository.AdminRepository;
import com.bng.ddaja.common.config.PublicKeyConfig;
import com.bng.ddaja.common.config.exception.exception.MemberNotFoundException;
import com.bng.ddaja.common.domain.Admin;
import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.common.util.DateUtil;
import com.bng.ddaja.tokens.dto.TokenDTO;
import com.bng.ddaja.tokens.repository.TokenRepository;
import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.repository.UserRepository;
import com.bng.ddaja.users.service.UserService;

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
public class TokenService {
    private PublicKeyConfig publicKeyConfig;
    private TokenRepository tokenRepository;
    private UserRepository userRepository;
    private AdminRepository adminRepository;

    public CommonJWT getCommonJWTByUserDTO(UserDTO userDTO) throws AuthenticationException {
        UserDTO user = new UserDTO(userRepository.findById(userDTO.getId()));
        if(user.getId() == 0) throw new AuthenticationException("User Info is Not Matched");
        CommonJWT result = new CommonJWT(user);
        result.setJwt(createJWTByCommonJWT(result));
        return result;
    }

    public CommonJWT getCommonJWTByAdminDTO(AdminDTO adminDTO) {
        Optional<Admin> adminVO = adminRepository.findById(adminDTO.getId());
        if(!adminVO.isPresent()) throw new MemberNotFoundException("해당 관리자 계정이 확인되지 않습니다.");
        AdminDTO admin = new AdminDTO(adminVO.get());
        // working
        return null;
    }

    public CommonJWT getCommonJWTByJWT(String jwt) {
        if(jwt == null) return new CommonJWT(false);
        return new CommonJWT(jwt, parseJWT(jwt));
    }

    private String createJWTByCommonJWT(CommonJWT commonJWT) {
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
