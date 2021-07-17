package com.bng.ddaja.words.dto;

import com.bng.ddaja.common.domain.License;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDTO {

    @ApiModelProperty(
        name = "w_id"
        , example = "11"
    )
    private long wId;

    @ApiModelProperty(
        name = "l_id"
        , example = "11"
    )
    private long lId;

    @ApiModelProperty(
        name = "title"
        , example = "리눅스 용어 외우기"
    )
    private String title;

    @ApiModelProperty(
        name = "License Entity"
    )
    private License license;
}
