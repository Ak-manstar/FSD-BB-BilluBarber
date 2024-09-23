package com.fsd.bookingService.document;

import com.fsd.bookingService.bean.Slot;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Document
public class AvailableSlots {
    @MongoId
    private String id;
    private Long vendorKey;
    private LocalDate date;
    private List<Slot> slots;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(Long vendorKey) {
        this.vendorKey = vendorKey;
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

    @Override
    public String toString() {
        return "AvailableSlots{" +
                "id='" + id + '\'' +
                ", vendorKey=" + vendorKey +
                ", date=" + date +
                ", slots=" + slots +
                '}';
    }
}