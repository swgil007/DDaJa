package com.bng.ddaja.common.error.exception;

import com.bng.ddaja.common.error.enums.ErrorCode;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
