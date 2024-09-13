package com.fsd.template.bean;

public class ResponseBean {

    private Object payload;
    private ErrorBean errorBean;
    private String status;


    public ResponseBean(Object payload) {
        this.payload = payload;
        this.status="SUCCESS";
    }

    public ResponseBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
        this.status="ERROR";
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
