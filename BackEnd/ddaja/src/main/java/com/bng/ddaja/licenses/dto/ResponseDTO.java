package com.bng.ddaja.licenses.dto;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
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
public class ResponseDTO {
    
    @ApiModelProperty(example = "111")
    private long seq;

    @ApiModelProperty(example = "길로그")
    private String name;
    
    @ApiModelProperty(example = "gillog")
    private String id;

    @ApiModelProperty(example = "2021-07-02")
    private Date created;

    @ApiModelProperty(example = "[{'rel' : 'self', 'href' : 'https://api.ddaja.com/licenses/111', 'method' : 'GET'}]")
    private List<String> links;
}
