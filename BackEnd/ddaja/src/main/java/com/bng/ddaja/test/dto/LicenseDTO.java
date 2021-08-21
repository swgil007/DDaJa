package com.bng.ddaja.test.dto;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

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
        name = "id"
        , example = "1"
    )
    private long id;

    @ApiModelProperty(
        name = "lCode"
        , example = "NONE"
    )
    private LicenseCode lCode;

    @ApiModelProperty(
        name = "name"
        , example = "정보처리기사"
    )
    private String name;

    @ApiModelProperty(
        name = "inUse"
        , example = "1"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "agency"
        , example = "Q-net"
    )
    private String agency;

    @ApiModelProperty(
        name = "passScore"
        , example = "60"
    )
    private int passScore; 
    
    @ApiModelProperty(
        name = "type"
        , example = "WRITING"
    )
    private LicenseType type;

    public LicenseDTO ( long id, String name ) {
        this.id = id;
        this.name = name;
    }
    
    public LicenseDTO ( License license ){
        this.id = license.getId();
        this.lCode = license.getLCode();
        this.passScore = license.getPassScore();
        this.name = license.getName();
        this.passScore = license.getPassScore();
        this.agency = license.getAgency();
    }

    // dtoToLicense 올바른 포현
    // 권장 : toEntity()
    // LicenseDTO class가 LicenseDTO를 받아서 License를 return?
    // LicenseDTO class가 본인 데이터로 License를 return하는게 좋아보임
    // new LicenseDTO().licenseToDto(license.findById(lid))에서 사용 중인데
    // 굳이 이렇게 사용하는 의도를 잘 모르겠음
    public License licenseToDto ( LicenseDTO dto ){

        return License.builder()
                        .id(dto.getId())
                        .name(dto.name)
                        .passScore(dto.passScore)
                        .agency(dto.agency)
                        .build();
    }
}
