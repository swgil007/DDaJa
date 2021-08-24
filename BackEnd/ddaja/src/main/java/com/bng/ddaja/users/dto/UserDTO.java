package com.bng.ddaja.users.dto;

import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.common.enums.TokenType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserDTO extends CommonDTO {
    private String userId;

    private String nickName;

    private String eMail;

    private String tokenOAuth;

    private TokenType tokenType;

    private String profileImg;

    public UserDTO(User vo) {
        id = vo.getId();
        userId = vo.getUserId();
        nickName = vo.getNickName();
        eMail = vo.getEMail() == null ? "" : vo.getEMail();
        tokenOAuth = vo.getTokenOAuth() == null ? "" : vo.getTokenOAuth();
        tokenType = vo.getTokenType();
        profileImg = vo.getProfileImg();
    }

    public User toEntity() {
        return User.builder()
                    .id(id)
                    .userId(userId)
                    .nickName(nickName)
                    .eMail(eMail)
                    .tokenOAuth(tokenOAuth)
                    .tokenType(tokenType)
                    .profileImg(profileImg)
                    .build();
    }
}
