package com.bng.ddaja.licenses.dto;

import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

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
public class LicenseDTO extends CommonDTO {
    
    private long id;
    private LicenseCode lCode;
    private String name;
    private boolean inUse;
    private String agency;
    private LicenseType type;
    private int passScore;
    
}
