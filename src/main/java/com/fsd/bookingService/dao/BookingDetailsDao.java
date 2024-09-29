package com.fsd.bookingService.dao;

import com.fsd.bookingService.document.BookingDetails;
import org.springframework.stereotype.Component;

@Component
public interface BookingDetailsDao {

    String saveBookingDetails(BookingDetails bookingDetails);
}