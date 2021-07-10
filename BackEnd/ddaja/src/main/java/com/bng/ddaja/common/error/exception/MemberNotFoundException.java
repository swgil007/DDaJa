package com.bng.ddaja.common.error.exception;

import com.bng.ddaja.common.error.enums.ErrorCode;

public class MemberNotFoundException extends CommonException {
    
    private static final long serialVersionUID = -214124124124214124L;
	
    public MemberNotFoundException() {
		super(ErrorCode.NOT_FOUND_MEMBER);
	}
}
