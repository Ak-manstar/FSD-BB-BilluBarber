package com.fsd.bookingService.bean;

public class ResponseBean {

    private Object payload;
    private ErrorBean errorBean;
    private String status;

    public ResponseBean() {
    }

    public ResponseBean(Object payload) {
        this.payload = payload;
        this.status="SUCCESS";
    }

    public ResponseBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
        this.status="ERROR";
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "payload='" + payload + '\'' +
                ", errorBean=" + errorBean +
                ", status='" + status + '\'' +
                '}';
    }
}