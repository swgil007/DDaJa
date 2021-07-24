package com.bng.ddaja.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class LicenseDTO {
    private long id;
    private String licenseName;
}
