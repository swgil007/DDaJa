package com.bng.ddaja.common.dto;

import com.bng.ddaja.common.enums.Roles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class CommonToken extends CommonDTO {
    private String userID;
    private String userName;
    private Roles role;
    private boolean isSuper;
}
