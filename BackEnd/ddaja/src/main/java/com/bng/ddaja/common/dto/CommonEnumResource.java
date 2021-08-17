package com.bng.ddaja.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommonEnumResource extends CommonResource {
    private String value;
    private String name;
    private String option;

    public CommonEnumResource(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public CommonEnumResource(String value, String name, String option) {
        this.value = value;
        this.name = name;
        this.option = option;
    }
}
