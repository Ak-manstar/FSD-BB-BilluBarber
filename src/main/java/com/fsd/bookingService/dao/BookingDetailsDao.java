package com.fsd.bookingService.dao;

import com.fsd.bookingService.document.BookingDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingDetailsDao {

    String saveBookingDetails(BookingDetails bookingDetails);
    BookingDetails getBookingDetailsByBookingId(String bookingId);
    List<BookingDetails> getBookingHistoryByCustomerId(String customerId);
    List<BookingDetails> getBookingHistoryByVendorId(String vendorId);
    List<BookingDetails> getBookingHistoryByVendorIdAndDate(String vendorId, String date);
}