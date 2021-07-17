package com.bng.ddaja.common.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.error.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;

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
public class CommonError {

    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommonErrorDetail> errors;

    public CommonError (ErrorCode errorCode) {
        this.code = errorCode.getStatus();
        this.message = errorCode.getMessage();
        errors = null;
    }
    
    public void setErrors(List<FieldError> fieldErrors) {
        errors = fieldErrors.stream().map(
            error -> new CommonErrorDetail
            (
                error.getCodes()[0]
                , error.getRejectedValue().toString()
                , error.getDefaultMessage()
            )
        ).collect(Collectors.toList());
    }
}
