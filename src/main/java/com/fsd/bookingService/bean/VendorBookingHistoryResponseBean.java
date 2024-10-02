package com.fsd.bookingService.bean;

import java.util.List;

public class VendorBookingHistoryResponseBean {

    private String vendorName;
    private Long vendorPhone;
    private List<CustomerBokingDetails> serviceHistory;

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

    public List<CustomerBokingDetails> getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(List<CustomerBokingDetails> serviceHistory) {
        this.serviceHistory = serviceHistory;
    }
}