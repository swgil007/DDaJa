package com.bng.ddaja.licenses.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDTO extends CommonDTO {
    
    private long id;
    private LicenseCode code;
    private String name;
    private boolean inUse;
    private String agency;
    private LicenseType type;
    private int passScore;
    private List<SubjectDTO> subjects;
    
    public LicenseDTO(License vo) {
        this.id = vo.getId();
        this.code = vo.getLCode();
        this.name = vo.getName();
        this.inUse = vo.isInUse();
        this.agency = vo.getAgency();
        this.type = vo.getType();
        this.passScore = vo.getPassScore();
        super.createdDate = vo.getCreatedDate();
        super.modifiedDate = vo.getModifiedDate();
        this.subjects = vo.getSubjects() == null ? null : vo.getSubjects().stream().map(v -> new SubjectDTO(v)).collect(Collectors.toList());
    }
    
    public License toEntity() {
        return License.builder()
        .id(this.id)
        .lCode(this.code)
        .name(this.name)
        .inUse(this.inUse)
        .agency(this.agency)
        .type(this.type)
        .passScore(this.passScore)
        .build();
    }

    public void valueCheck() {
        System.out.println("====== LicenseDTO ToString ====== ");
        System.out.println("ID         : " + this.id);
        System.out.println("CODE       : " + this.code);
        System.out.println("NAME       : " + this.name);
        System.out.println("IN USE     : " + this.inUse);
        System.out.println("AGENCY     : " + this.agency);
        System.out.println("TYPE       : " + this.type);
        System.out.println("PASS SCORE : " + this.passScore);
        System.out.println("====================================");
    }
}
