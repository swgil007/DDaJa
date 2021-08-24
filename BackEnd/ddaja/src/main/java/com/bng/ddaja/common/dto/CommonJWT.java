package com.bng.ddaja.common.dto;

import com.bng.ddaja.common.enums.Roles;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonJWT {
    private long id;
    private String userID;
    private String userName;
    private Roles role;
    private Claims claims;

    public CommonJWT(long id,  String userID, String userName, Roles role) {
        this.id = id;
        this.userID = userID;
        this.userName = userName;
        this.role = role;
    }

    public CommonJWT(Claims claims) {
        this.claims = claims;
    }
}
