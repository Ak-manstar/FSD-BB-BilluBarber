package com.fsd.bookingService.daoImpl;

import com.fsd.bookingService.dao.BookingDetailsDao;
import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.helper.BookingStatus;
import com.fsd.bookingService.repository.mongo.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDetailsDaoImpl implements BookingDetailsDao {

    @Autowired
    BookingDetailsRepository bookingDetailsRepository;

    @Override
    public String saveBookingDetails(BookingDetails bookingDetails) {
        BookingDetails existingBooking=getBookingDetailsByBookingId(bookingDetails.getBookingId());
        if(null!=existingBooking){
            existingBooking.setSlots(bookingDetails.getSlots());
            existingBooking.setStatus(bookingDetails.getStatus());
            bookingDetailsRepository.save(existingBooking);
            return existingBooking.getBookingId();
        }else{
            bookingDetails.setStatus(BookingStatus.BOOKED);
            bookingDetailsRepository.save(bookingDetails);
            return bookingDetails.getBookingId();
        }
    }

    @Override
    public BookingDetails getBookingDetailsByBookingId(String bookingId) {
        return bookingDetailsRepository.findByBookingId(bookingId);
    }

    @Override
    public List<BookingDetails> getBookingHistoryByCustomerId(String customerId) {
        return bookingDetailsRepository.findByCustomerId(customerId);
    }

    @Override
    public List<BookingDetails> getBookingHistoryByVendorId(String vendorId) {
        return bookingDetailsRepository.findByVendorId(vendorId);
    }

    @Override
    public List<BookingDetails> getBookingHistoryByVendorIdAndDate(String vendorId, String date) {
        return bookingDetailsRepository.findByVendorIdAndDate(vendorId,date);
    }
}