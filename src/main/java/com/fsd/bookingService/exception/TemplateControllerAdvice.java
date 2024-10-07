package com.fsd.bookingService.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TemplateControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= BookingServiceException.class)
    protected ResponseEntity<Object> handleTemplateException(BookingServiceException exception){
        return new ResponseEntity<>(exception.getErrorBean(),exception.getHttpStatus());
    }
}