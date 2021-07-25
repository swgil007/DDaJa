package com.bng.ddaja.test.dto;

import com.bng.ddaja.common.domain.License;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class LicenseDTO {

    private long id;
    private String licenseName;

    public LicenseDTO ( License license ){
        this.id = license.getId();
        this.licenseName = license.getName();
    }
}
