package com.bng.ddaja.users.dto;

import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.common.enums.TokenType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends CommonDTO {
    private String userId;

    private String nickName;

    private String eMail;

    private String jwt;

    private String profileImg;

    public UserDTO(User vo) {
        if(vo == null) return;
        id = vo.getId();
        userId = vo.getUserId();
        nickName = vo.getNickName();
        eMail = vo.getEMail() == null ? "" : vo.getEMail();
        profileImg = vo.getProfileImg();
    }

    public UserDTO(User vo, boolean isCreated) {
        if(vo == null) return;
        id = vo.getId();
        userId = vo.getUserId();
        nickName = vo.getNickName();
        eMail = vo.getEMail() == null ? "" : vo.getEMail();
        profileImg = vo.getProfileImg();
        super.isCreated = isCreated;
    }

    public User toEntity() {
        return User.builder()
                    .id(id)
                    .userId(userId)
                    .nickName(nickName)
                    .eMail(eMail)
                    .profileImg(profileImg)
                    .build();
    }
}
