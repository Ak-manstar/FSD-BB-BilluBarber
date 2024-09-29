package com.fsd.bookingService.bean;

import java.time.LocalDate;
import java.util.List;

public class AvailableSlotsResponseBean {

    private String vendorId;
    private LocalDate date;
    private List<Slot> slots;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}