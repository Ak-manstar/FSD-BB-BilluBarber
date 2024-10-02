package com.fsd.bookingService.bean;

import java.util.List;

public class CustomerVendorBookingDetails {

    private String vendorName;
    private Long vendorPhone;
    private String vendorAddress;
    private String date;
    private List<BookedSlotResponseBean> services;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(Long vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public List<BookedSlotResponseBean> getServices() {
        return services;
    }

    public void setServices(List<BookedSlotResponseBean> services) {
        this.services = services;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}