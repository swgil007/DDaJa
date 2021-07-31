package com.bng.ddaja.test.dto;

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
public class LicenseDTO {

    @ApiModelProperty(
        name = "l_id"
        , example = "11"
    )
    private long id;

    @ApiModelProperty(
        name = "licenseName"
        , example = "정보처리기사"
    )
    private String licenseName;

    @ApiModelProperty(
        name = "inUse"
        , example = "1"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "agency"
        , example = "-"
    )
    private String agency;

    @ApiModelProperty(
        name = "passScore"
        , example = "50"
    )
    private int passScore; 
    
    public LicenseDTO ( long id, String licenseName ) {
        this.id          = id;
        this.licenseName = licenseName;
    }
    
    public LicenseDTO ( License license ){
        this.id          = license.getId(); 
        this.passScore   = license.getPassScore();
        this.licenseName = license.getName();
        this.passScore   = license.getPassScore();
        this.agency      = license.getAgency();
    }

}
