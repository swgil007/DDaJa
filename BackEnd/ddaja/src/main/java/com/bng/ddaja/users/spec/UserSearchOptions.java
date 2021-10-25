package com.bng.ddaja.users.spec;

import com.bng.ddaja.common.dto.CommonEnumResource;
import com.bng.ddaja.common.enums.CommonEnum;

public enum UserSearchOptions implements CommonEnum {
    NICKNAME("사용자 닉네임", "nickName")
    , ID("사용자 ID", "id");

    private String name;
    private String query;

    UserSearchOptions(String name, String query) {
        this.name = name;
        this.query = query;
    }

    @Override
    public CommonEnumResource toCommonEnumResource() {
        return new CommonEnumResource(name(), name, query);
    }
}
