package com.bng.ddaja.words.spec;

import com.bng.ddaja.common.dto.CommonEnumResource;
import com.bng.ddaja.common.spec.CommonSearchOption;

import lombok.Getter;

@Getter
public enum WordSearchOptions implements CommonSearchOption{

    NAME("단어 목록명", "name")
    , LICENSEID("자격증 ID", "licenseID");

    private String name;
    private String query;

    WordSearchOptions( String name, String query ){
        this.name = name;
        this.query = query;
    }

    @Override
    public CommonEnumResource toCommonEnumResource(){
        return new CommonEnumResource(name(), name, query);
    }
}