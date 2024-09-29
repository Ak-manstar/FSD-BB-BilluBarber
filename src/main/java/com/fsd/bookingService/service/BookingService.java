package com.fsd.bookingService.service;

import com.fsd.bookingService.bean.AvailableSlotsResponseBean;
import com.fsd.bookingService.bean.BookingDetailsResponseBean;
import com.fsd.bookingService.bean.CreateBookingRequestBean;
import com.fsd.bookingService.bean.Slot;
//import com.fsd.bookingService.document.AvailableSlots;
//import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.entity.AvailableSlotsEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public interface BookingService {

    //here you can declare methods of service

    //    getAvailableSlots
//    createBooking
//    getBookingDetails
//    updateBookingDetails
//    cancelbooking
//    updateBookingStatus

    AvailableSlotsResponseBean getAvailableSlots(String vendorId, LocalDate dateTime);
    BookingDetailsResponseBean createBooking(String vendorId, LocalDate dateTime , LocalTime time,List<String> services);

}