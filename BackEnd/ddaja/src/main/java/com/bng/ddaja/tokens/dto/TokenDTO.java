package com.bng.ddaja.tokens.dto;

import java.util.Date;

import com.bng.ddaja.common.domain.Token;
import com.bng.ddaja.common.domain.Token.TokenBuilder;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.users.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class TokenDTO extends CommonDTO {
    
    private String jwt;
    
    private String refresh;

    private Date expire;

    private String issuance;

    private UserDTO user;

    public TokenDTO(Token vo) {
        id = vo.getId();
        jwt = vo.getJwt();
        refresh = vo.getRefresh();
        expire = vo.getExpire();
        issuance = vo.getIssuance();
        user = vo.getUser() == null ? null : new UserDTO(vo.getUser());
    }

    public Token toEntity() {
        TokenBuilder builder = Token.builder()
                    .id(id)
                    .jwt(jwt)
                    .refresh(refresh)
                    .expire(expire)
                    .issuance(issuance);
        if(user != null) builder.user(user.toEntity());
        return builder.build();
    }
}
