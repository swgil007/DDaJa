package com.bng.ddaja.common.enums;

import lombok.Getter;

@Getter
public enum AuthRequiredURLs {
    USER("user");

    private String name;

    AuthRequiredURLs(String name) {
        this.name = name;
    }
}
