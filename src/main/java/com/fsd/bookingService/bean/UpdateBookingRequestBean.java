package com.fsd.bookingService.bean;

import java.util.List;

public class UpdateBookingRequestBean {

    private List<SlotBookingRequestBean> addServices;
    private List<String> removeServices;

    public List<SlotBookingRequestBean> getAddServices() {
        return addServices;
    }

    public void setAddServices(List<SlotBookingRequestBean> addServices) {
        this.addServices = addServices;
    }

    public List<String> getRemoveServices() {
        return removeServices;
    }

    public void setRemoveServices(List<String> removeServices) {
        this.removeServices = removeServices;
    }
}