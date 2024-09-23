package com.fsd.bookingService.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class BookingDetails {

    @MongoId
    private String id;
    private String bookingId;
    private List<String> services;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "BookingDetailsRepository{" +
                "id='" + id + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", services=" + services +
                '}';
    }
}