package com.bng.ddaja.test.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    
    @ApiParam(value = "사용자 ID", required = true)
    private String id;

    @ApiParam(value = "사용자 이름")
    private String name;
}
