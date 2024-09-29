package com.fsd.bookingService.bean;

public class BookedSlotResponseBean {

    private String serviceName;
    private String time;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}