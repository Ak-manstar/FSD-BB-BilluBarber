package com.fsd.bookingService.service;

import com.fsd.bookingService.bean.CreateBookingRequestBean;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.document.BookingDetails;
import org.springframework.stereotype.Component;

@Component
public interface BookingService {

    //here you can declare methods of service

    //    getAvailableSlots
//    createBooking
//    getBookingDetails
//    updateBookingDetails
//    cancelbooking
//    updateBookingStatus

    AvailableSlots getAvailableSlots(Long vendorKey,String dateTime);
    BookingDetails createBooking(CreateBookingRequestBean createBookingRequestBean);

}