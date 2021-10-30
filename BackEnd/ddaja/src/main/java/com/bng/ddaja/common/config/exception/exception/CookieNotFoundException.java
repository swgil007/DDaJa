package com.bng.ddaja.common.config.exception.exception;

import com.bng.ddaja.common.config.exception.enums.ExceptionCode;

public class CookieNotFoundException extends CommonException {
    
    private static final long serialVersionUID = -21412412414111124L;

    public CookieNotFoundException() {
        super(ExceptionCode.NOT_FOUND);
    }
}
