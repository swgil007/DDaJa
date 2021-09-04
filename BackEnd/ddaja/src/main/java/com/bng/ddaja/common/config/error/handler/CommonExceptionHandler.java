package com.bng.ddaja.common.config.error.handler;

import java.util.HashMap;
import java.util.Map;

import javax.security.sasl.AuthenticationException;

import com.bng.ddaja.common.config.error.enums.ErrorCode;
import com.bng.ddaja.common.config.error.exception.MemberNotFoundException;
import com.bng.ddaja.common.config.error.exception.NotAcceptableSocialLoginException;
import com.bng.ddaja.common.config.error.exception.NotAcceptableSocialResponseException;
import com.bng.ddaja.common.dto.CommonError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.jsonwebtoken.JwtException;

@RestControllerAdvice
public class CommonExceptionHandler {
    
    // @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    // public ResponseEntity<CommonError> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    //     CommonError error = new CommonError(HttpStatus.METHOD_NOT_ALLOWED.value(), "Not Supported Method :(", null);
    //     return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    // }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<CommonError> handleJwtException(JwtException e) {
        CommonError error = new CommonError(ErrorCode.UNAUTHORIZED);
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<CommonError> handleAuthenticationException(AuthenticationException e) {    
        CommonError error = new CommonError(ErrorCode.UNAUTHORIZED);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CommonError> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        CommonError error = new CommonError(ErrorCode.NOT_READABLE_MESSAGE);
        error.setReason(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<CommonError> handleMemberNotFoundException(MemberNotFoundException e) {
        return new ResponseEntity<>(new CommonError(ErrorCode.NOT_FOUND_MEMBER), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotAcceptableSocialLoginException.class)
    public ResponseEntity<CommonError> handleNotAcceptableSocialLoginException(NotAcceptableSocialLoginException e) {
        return new ResponseEntity<>(new CommonError(ErrorCode.NOT_ACCEPTABLE_SOCIAL_LOGIN), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NotAcceptableSocialResponseException.class)
    public ResponseEntity<CommonError> handleNotAcceptableSocialResponseException(NotAcceptableSocialResponseException e) {
        return new ResponseEntity<>(new CommonError(ErrorCode.NOT_ACCEPTABLE_SOCIAL_RESPONSE), HttpStatus.NOT_ACCEPTABLE);
    }
}