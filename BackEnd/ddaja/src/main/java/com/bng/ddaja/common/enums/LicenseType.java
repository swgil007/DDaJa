package com.bng.ddaja.common.enums;

import lombok.Getter;

@Getter
public enum LicenseType {
    NONE("")
    , WRITING("필기")
    , PERFORM("실기");

    private String name;

    LicenseType(String name) {
        this.name = name;
    }
}