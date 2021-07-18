package com.bng.ddaja.example.dto;

import com.bng.ddaja.common.domain.User;

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
        , example = "11"
    )
    @ApiParam(value = "사용자 SEQ ID")
    private Long id;

    @ApiModelProperty(
        name = "id"
        , example = "gillog"
    )
    @ApiParam(value = "사용자 ID", required = true)
    private String userId;

    @ApiModelProperty(example = "길로그")
    @ApiParam(value = "사용자 이름")
    private String nickName;

    public UserDTO(User user) {

        this.id = user.getId();
        this.userId = user.getUserId();
        this.nickName = user.getNickName();
    }
}
