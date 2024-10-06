package com.fsd.bookingService.bean;

import java.time.LocalDate;
import java.util.List;

public class CreateBookingRequestBean {

    private LocalDate date;
    private List<SlotBookingRequestBean> services;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<SlotBookingRequestBean> getServices() {
        return services;
    }

    public void setServices(List<SlotBookingRequestBean> services) {
        this.services = services;
    }
}