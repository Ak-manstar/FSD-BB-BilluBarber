package com.fsd.bookingService.document;

import com.fsd.bookingService.bean.BookedSlotResponseBean;
import com.fsd.bookingService.helper.BookingStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class BookingDetails {
    @Id
    private String id;
    private String bookingId;
    private String vendorId;
    private String customerId;
    private String date;
    private BookingStatus status;
    private List<BookedSlotResponseBean> slots;

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<BookedSlotResponseBean> getSlots() {
        return slots;
    }

    public void setSlots(List<BookedSlotResponseBean> slots) {
        this.slots = slots;
    }
}