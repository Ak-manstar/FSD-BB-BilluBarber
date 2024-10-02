package com.fsd.bookingService.bean;

public class VerdorServiceResponseBean {

    private Long vendorServicekey;
    private String serviceName;
    private Long price;

    public Long getVendorServicekey() {
        return vendorServicekey;
    }

    public void setVendorServicekey(Long vendorServicekey) {
        this.vendorServicekey = vendorServicekey;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}