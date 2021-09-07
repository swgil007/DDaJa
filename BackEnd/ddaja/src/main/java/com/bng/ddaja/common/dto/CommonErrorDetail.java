package com.bng.ddaja.common.dto;

import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonErrorDetail {
    private String field;
    private String value;
    private String reason;

    public CommonErrorDetail(String field, String reason) {
        this.field = field;
        this.reason = reason;
    }

    public CommonErrorDetail(FieldError e) {
        field = e.getField();
        reason = e.getDefaultMessage();
        if(e.getRejectedValue() != null) value = e.getRejectedValue().toString();
    }
}
