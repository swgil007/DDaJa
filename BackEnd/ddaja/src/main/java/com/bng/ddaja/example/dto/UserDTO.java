package com.bng.ddaja.example.dto;

import com.bng.ddaja.common.domain.user.User;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    
    @ApiModelProperty(
        name = "id"
        , example = "gillog"
    )
    @ApiParam(value = "사용자 ID", required = true)
    private String id;

    @ApiModelProperty(example = "길로그")
    @ApiParam(value = "사용자 이름")
    private String nickName;

    public UserDTO(User user) {
        this.id = user.getId();
        this.nickName = user.getNickName();
    }
}
