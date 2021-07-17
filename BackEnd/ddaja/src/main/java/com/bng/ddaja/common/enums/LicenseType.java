package com.bng.ddaja.common.enums;

public enum LicenseType {
    NONE("")
    , WRITING("필기")
    , PERFORM("실기");

    private String name;

    LicenseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}