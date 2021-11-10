package com.bng.ddaja.admin.dto;

import javax.validation.constraints.NotBlank;

import com.bng.ddaja.common.domain.Admin;
import com.bng.ddaja.common.dto.CommonToken;
import com.bng.ddaja.common.enums.AdminRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO extends CommonToken {
    @NotBlank(message = "로그인 ID는 필수 값 입니다.")
    private String loginID;
    @NotBlank(message = "로그인 PASS는 필수 값 입니다.")
    private String passWord;
    private AdminRole adminRole;
    private boolean inUse;
    private String jwt;

    public AdminDTO(Admin vo) {
        id = vo.getId();
        loginID = vo.getLoginID();
        adminRole = vo.getRole();
        inUse = vo.isInUse();
    }
}
