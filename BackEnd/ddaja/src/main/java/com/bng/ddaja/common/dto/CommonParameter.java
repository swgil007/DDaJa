package com.bng.ddaja.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Query Parameter")
@Getter
@Setter
@ToString
public class CommonParameter {
    @ApiModelProperty(example = "q=inuse=true,name=정처기")
    private String q;
    @ApiModelProperty(example = "fields=inuse,name,time")
    private String[] fields;
    @ApiModelProperty(example = "page=1")
    private int page = 1;
    @ApiModelProperty(example = "limit=10")
    private int limit = 10;
}
