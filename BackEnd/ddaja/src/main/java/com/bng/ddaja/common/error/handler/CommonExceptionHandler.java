package com.bng.ddaja.common.error.handler;

import com.bng.ddaja.common.dto.CommonError;
import com.bng.ddaja.common.error.enums.ErrorCode;
import com.bng.ddaja.common.error.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
    
    // @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    // public ResponseEntity<CommonError> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    //     CommonError error = new CommonError(HttpStatus.METHOD_NOT_ALLOWED.value(), "Not Supported Method :(", null);
    //     return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    // }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<CommonError> handleMemberNotFoundException(MemberNotFoundException e) {
        CommonError error = new CommonError(ErrorCode.NOT_FOUND_MEMBER);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}