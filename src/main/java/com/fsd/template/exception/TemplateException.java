package com.fsd.template.exception;

import com.fsd.template.bean.ErrorBean;
import org.springframework.http.HttpStatus;

public class TemplateException extends RuntimeException{

    private ErrorBean errorBean;
    private HttpStatus httpStatus;

    public TemplateException(ErrorBean errorBean, HttpStatus httpStatus) {
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
        return "TemplateException{" +
                "errorBean=" + errorBean +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
