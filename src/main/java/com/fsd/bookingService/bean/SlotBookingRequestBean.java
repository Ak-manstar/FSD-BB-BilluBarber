package com.fsd.bookingService.bean;

import java.time.LocalTime;

public class SlotBookingRequestBean {

    Long serviceKey;
    LocalTime time;

    public Long getServiceKey() {
        return serviceKey;
    }

    public void setServiceKey(Long serviceKey) {
        this.serviceKey = serviceKey;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}