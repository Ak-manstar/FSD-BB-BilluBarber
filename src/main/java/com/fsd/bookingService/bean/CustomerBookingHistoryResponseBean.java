package com.fsd.bookingService.bean;

import java.util.List;

public class CustomerBookingHistoryResponseBean {
    private String customerName;
    private Long customerPhone;
    private List<CustomerVendorBookingDetails> serviceHistory;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CustomerVendorBookingDetails> getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(List<CustomerVendorBookingDetails> serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public Long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone) {
        this.customerPhone = customerPhone;
    }
}