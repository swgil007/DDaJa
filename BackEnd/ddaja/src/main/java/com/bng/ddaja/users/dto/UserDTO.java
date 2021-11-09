package com.bng.ddaja.users.dto;

import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.domain.User.UserBuilder;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.util.CommonUtil;

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
    private String profileImg;
    private String jwt;
    private CommonJWT commonJWT;

    public UserDTO(User vo) {
        if(vo == null) return;
        id = vo.getId();
        userId = vo.getUserId();
        nickName = vo.getNickName();
        eMail = vo.getEMail() == null ? "" : vo.getEMail();
        profileImg = vo.getProfileImg();
        createdDate = vo.getCreatedDate();
        modifiedDate = vo.getModifiedDate();
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
        UserBuilder userBuilder = User.builder();
        userBuilder.id(id);
        if(CommonUtil.isNotEmptyString(userId)) userBuilder.userId(userId);
        if(CommonUtil.isNotEmptyString(nickName)) userBuilder.nickName(nickName);
        if(CommonUtil.isNotEmptyString(eMail)) userBuilder.eMail(eMail);
        if(CommonUtil.isNotEmptyString(profileImg)) userBuilder.profileImg(profileImg);
        return userBuilder.build();
    }
}
