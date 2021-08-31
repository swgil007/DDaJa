package com.bng.ddaja.common.config.error.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    
    INVALID_PARAMETER(400, "Invalid Request Parameter")
    , NOT_FOUND(404, "Not Founded Resource")
    , NOT_ALLOWED_METHOD(405, "Not Allowed Method")
    , NOT_FOUND_MEMBER(404, "Not Founded Memeber")
    , UNAUTHORIZED(401, "Unauthorized")
    , NOT_ACCEPTABLE_SOCIAL_LOGIN(406, "Not Acceptable Social Login Type")
    , NOT_ACCEPTABLE_SOCIAL_RESPONSE(406, "Social Third Party Response is not Successed");

    private final int status;
    private final String message;

    ErrorCode(final int status, final String message) {
        this.status = status;
        this.message = message;
    }
}
