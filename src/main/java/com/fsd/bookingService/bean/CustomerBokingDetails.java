package com.fsd.bookingService.bean;

import java.util.List;

public class CustomerBokingDetails {

    private String customerName;
    private Long customerPhone;
    private String date;
    private String bookingId;
    private List<BookedSlotResponseBean> services;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<BookedSlotResponseBean> getServices() {
        return services;
    }

    public void setServices(List<BookedSlotResponseBean> services) {
        this.services = services;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}