package com.fsd.bookingService.exception;

import com.fsd.bookingService.bean.ErrorBean;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class BookingServiceException  extends RuntimeException implements Supplier{

    private ErrorBean errorBean;
    private HttpStatus httpStatus;

    public BookingServiceException(ErrorBean errorBean, HttpStatus httpStatus) {
        this.errorBean = errorBean;
        this.httpStatus = httpStatus;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String toString() {
        return "BookingServiceException{" +
                "errorBean=" + errorBean +
                ", httpStatus=" + httpStatus +
                '}';
    }

    @Override
    public Object get() {
        return null;
    }
}