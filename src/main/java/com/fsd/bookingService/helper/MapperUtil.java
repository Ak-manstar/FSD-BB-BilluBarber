package com.fsd.bookingService.helper;

import com.fsd.bookingService.bean.BookedSlotResponseBean;
import com.fsd.bookingService.bean.Slot;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.document.BookingDetails;

import java.time.LocalDate;
import java.util.List;

public class MapperUtil {

    public static AvailableSlots mapAvailableSlots(String vendorId, String date, List<Slot> availableSlots) {
        AvailableSlots availableSlotsDoc=new AvailableSlots();
        availableSlotsDoc.setVendorId(vendorId);
        availableSlotsDoc.setDate(date);
        availableSlotsDoc.setSlots(availableSlots);
        return availableSlotsDoc;
    }

    public static BookingDetails mapBookingDetails(String vendorId, LocalDate date, String customerId, String bookingId, List<BookedSlotResponseBean> slots) {
        BookingDetails bookingDetails=new BookingDetails();
        bookingDetails.setBookingId(bookingId);
        bookingDetails.setCustomerId(customerId);
        bookingDetails.setDate(date.toString());
        bookingDetails.setVendorId(vendorId);
        bookingDetails.setSlots(slots);
        return bookingDetails;
    }
}