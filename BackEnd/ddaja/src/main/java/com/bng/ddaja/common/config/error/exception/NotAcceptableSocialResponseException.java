package com.bng.ddaja.common.config.error.exception;

import com.bng.ddaja.common.config.error.enums.ErrorCode;

public class NotAcceptableSocialResponseException extends CommonException {
    public NotAcceptableSocialResponseException() {
        super(ErrorCode.NOT_ACCEPTABLE_SOCIAL_RESPONSE);
    }
    public NotAcceptableSocialResponseException(String message) {
        super(ErrorCode.NOT_ACCEPTABLE_SOCIAL_RESPONSE, message);
    }
}
