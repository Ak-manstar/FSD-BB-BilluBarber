package com.fsd.bookingService.service;

import com.fsd.bookingService.bean.*;
import com.fsd.bookingService.document.BookingDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public interface BookingService {

//    updateBookingDetails
//    cancelbooking
//    updateBookingStatus

    AvailableSlotsResponseBean getAvailableSlots(String vendorId, LocalDate dateTime);
    BookingDetails createBooking(String vendorId, CreateBookingRequestBean createBookingRequestBean, String customerId);
    BookingDetails getBookingDetails(String bookingId);
    CustomerBookingHistoryResponseBean getCustomerBookingHistory(String customerId);
    VendorBookingHistoryResponseBean getVendorBookingHistory(String vendorId);
//    BookingDetails updateBooking(String bookingId, UpdateBookingRequestBean updateBookingRequestBean);
}