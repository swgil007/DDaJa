package com.bng.ddaja.common.config.error.exception;

import com.bng.ddaja.common.config.error.enums.ErrorCode;

public class InvalidParameterException extends CommonException {

    private static final long serialVersionUID = -214124124141124124L;

	public InvalidParameterException() {
		super(ErrorCode.INVALID_PARAMETER);
	}
    
}
