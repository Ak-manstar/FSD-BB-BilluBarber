package com.fsd.bookingService.bean;

public class BookedSlotResponseBean {

    private String serviceName;
    private Long vendorServiceKey;
    private String time;
    private Long price;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getVendorServiceKey() {
        return vendorServiceKey;
    }

    public void setVendorServiceKey(Long vendorServiceKey) {
        this.vendorServiceKey = vendorServiceKey;
    }
}