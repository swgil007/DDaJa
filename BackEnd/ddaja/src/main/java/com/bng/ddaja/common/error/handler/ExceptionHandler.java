package com.bng.ddaja.common.error.handler;

import com.bng.ddaja.common.dto.CommonError;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    

    //public ResponseEntity<CommonError> handleHttpMessageNotReadable
}
