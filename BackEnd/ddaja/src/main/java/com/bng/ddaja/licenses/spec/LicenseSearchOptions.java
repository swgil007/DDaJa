package com.bng.ddaja.licenses.spec;

import lombok.Getter;

@Getter
public enum LicenseSearchOptions {
    NAME("자격증 이름"), SUBJECTNAME("과목 이름"), INUSE("사용 여부");

    private String name;
    
    LicenseSearchOptions(String name) {
        this.name = name;
    }
}
