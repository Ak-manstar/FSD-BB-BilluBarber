package com.fsd.bookingService.serviceImpl;

import com.fsd.bookingService.bean.CreateBookingRequestBean;
import com.fsd.bookingService.client.VendorClient;
import com.fsd.bookingService.dao.AvailableSlotsDao;
import com.fsd.bookingService.dao.BookingDetailsDao;
import com.fsd.bookingService.dao.BookingsDao;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingsDao bookingsDao;

    @Autowired
    AvailableSlotsDao availableSlotsDao;

    @Autowired
    BookingDetailsDao bookingDetailsDao;

    @Autowired
    VendorClient client;


    @Override
    public AvailableSlots getAvailableSlots(Long vendorKey,String dateTime) {
        LocalDateTime localDateTime=LocalDateTime.parse(dateTime);
//        String date=localDateTime.toLocalDate().toString();
//        String time=localDateTime.toLocalTime().toString();
        AvailableSlots availableSlots=availableSlotsDao.getAvailableSlots(vendorKey,localDateTime.toLocalDate());
        if(null!=availableSlots){

        }
        return null;,de
      //  return null;
    }

    @Override
    public BookingDetails createBooking(CreateBookingRequestBean createBookingRequestBean) {
        return null;
    }
}