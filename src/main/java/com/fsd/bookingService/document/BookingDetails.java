package com.fsd.bookingService.document;

import com.fsd.bookingService.bean.BookedSlotResponseBean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class BookingDetails {
    @Id
    private String bookingId;
    private String vendorId;
    private String date;
    private List<BookedSlotResponseBean> slots;

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