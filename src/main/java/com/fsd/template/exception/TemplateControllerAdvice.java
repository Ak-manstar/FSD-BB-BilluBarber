package com.fsd.template.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TemplateControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=TemplateException.class)
    protected ResponseEntity<Object> handleTemplateException(TemplateException exception){
        return new ResponseEntity<>(exception.getErrorBean(),exception.getHttpStatus());
    }
}
