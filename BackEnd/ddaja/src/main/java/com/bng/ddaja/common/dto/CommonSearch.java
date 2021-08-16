package com.bng.ddaja.common.dto;

import org.springframework.data.domain.Pageable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "공통 검색 모델")
@Getter
@Setter
@ToString
public class CommonSearch {

    @ApiModelProperty(example = "page=1")
    private int page = 1;

    @ApiModelProperty(example = "size=10")
    private int size = 10;

}
