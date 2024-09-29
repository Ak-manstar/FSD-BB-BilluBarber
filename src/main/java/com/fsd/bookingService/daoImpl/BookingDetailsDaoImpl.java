package com.fsd.bookingService.daoImpl;

import com.fsd.bookingService.dao.BookingDetailsDao;
import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.repository.mongo.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingDetailsDaoImpl implements BookingDetailsDao {

    @Autowired
    BookingDetailsRepository bookingDetailsRepository;

    @Override
    public String saveBookingDetails(BookingDetails bookingDetails) {
        return bookingDetailsRepository.save(bookingDetails).getBookingId();
    }
}