package com.bng.ddaja.common.error.handler;

import java.util.HashMap;
import java.util.Map;

import com.bng.ddaja.common.domain.dto.CommonError;
import com.bng.ddaja.common.error.enums.ErrorCode;
import com.bng.ddaja.common.error.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonExceptionHandler {
    
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}