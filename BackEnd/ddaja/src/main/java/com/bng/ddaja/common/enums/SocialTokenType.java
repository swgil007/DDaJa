package com.bng.ddaja.common.enums;

import lombok.Getter;

@Getter
public enum SocialTokenType {
    NONE(""), KAKAO("카카오"), NAVER("네이버"), APPLE("애플"), GOOGLE("구글");

    private String type;

    SocialTokenType(String type) {
        this.type = type;
    }
}
