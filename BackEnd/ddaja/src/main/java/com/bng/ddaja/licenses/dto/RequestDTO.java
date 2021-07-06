package com.bng.ddaja.licenses.dto;

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
public class RequestDTO {
    
    @ApiModelProperty(example = "gillog")
    private String id;

    @ApiModelProperty(example = "길록")
    private String name;
    
    @ApiModelProperty(example = "[{'field1' : value, 'field2' : value}]")
    private List<String> fields;

}
