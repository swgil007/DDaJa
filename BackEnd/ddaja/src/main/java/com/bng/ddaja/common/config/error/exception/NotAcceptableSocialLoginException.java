package com.bng.ddaja.common.config.error.exception;

import com.bng.ddaja.common.config.error.enums.ErrorCode;

public class NotAcceptableSocialLoginException extends CommonException {
    public NotAcceptableSocialLoginException() {
        super(ErrorCode.NOT_ACCEPTABLE_SOCIAL_LOGIN);
    }
    public NotAcceptableSocialLoginException(String meesage) {
        super(ErrorCode.NOT_ACCEPTABLE_SOCIAL_LOGIN, meesage);
    }
}
