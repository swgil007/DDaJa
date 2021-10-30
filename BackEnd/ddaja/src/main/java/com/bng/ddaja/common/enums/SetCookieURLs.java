package com.bng.ddaja.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SetCookieURLs {
    LOGIN_ADMIN("/admin/login");

    private String name;
}
