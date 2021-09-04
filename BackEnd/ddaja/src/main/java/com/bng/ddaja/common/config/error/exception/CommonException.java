package com.bng.ddaja.common.config.error.exception;

import com.bng.ddaja.common.config.error.enums.ErrorCode;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;
    private String message;

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
    public CommonException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
