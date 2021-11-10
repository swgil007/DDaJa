package com.bng.ddaja.common.dto;

import com.bng.ddaja.admin.dto.AdminDTO;
import com.bng.ddaja.common.enums.AdminRole;
import com.bng.ddaja.common.enums.Roles;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.users.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@JsonIgnoreProperties({ "id", "userID", "userName", "role", "claims" })
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonJWT extends CommonToken {
    private String jwt;
    private long id;
    private Claims claims;
    private boolean isValidated;

    public CommonJWT(UserDTO userDTO) {
        id = userDTO.getId();
        setUserID(userDTO.getUserId());
        setUserName(userDTO.getNickName());
        setRole(Roles.USER);
        isValidated = true;
    }

    public CommonJWT(AdminDTO adminDTO) {
        id = adminDTO.getId();
        setUserID(adminDTO.getLoginID());
        setRole(Roles.ADMIN);
        isValidated = true;
        setSuper(AdminRole.SUPER.equals(adminDTO.getAdminRole()));
    }
    
    public CommonJWT(long id,  String userID, String userName, Roles role) {
        this.id = id;
        setUserID(userID);
        setUserName(userName);
        setRole(role);
    }

    public CommonJWT(String jwt, Claims claims) {
        this.jwt = jwt;
        if(claims == null) return;
        this.claims = claims;
        id = Integer.toUnsignedLong((int) claims.get(Constants.CLAIMS_ID));
        setUserID((String) claims.get(Constants.CLAIMS_USER_ID));
        setUserName((String) claims.get(Constants.CLAIMS_USER_NAME));
        setRole(Roles.valueOf((String) claims.get(Constants.CLAIMS_ROLE)));
        this.isValidated = true;
    }

    public CommonJWT(boolean isvalidated) {
        this.isValidated = isvalidated;
    }

    public CommonJWT(String jwt) {
        this.jwt = jwt;
    }
}
