package com.bng.ddaja.licenses.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(description = "에러 상태")
public class ErrorDTO {
    
    @ApiModelProperty(example = "1")
    private String code;
    @ApiModelProperty(example = "올바르지 않은 회원 ID")
    private String message;
}
