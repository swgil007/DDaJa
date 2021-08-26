package com.bng.ddaja.common.enums;

import lombok.Getter;

@Getter
public enum AuthRequiredURLs {
    TOKEN("token"), TEST("test");

    private String name;

    AuthRequiredURLs(String name) {
        this.name = name;
    }
}
