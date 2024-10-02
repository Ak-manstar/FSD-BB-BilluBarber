package com.fsd.bookingService.repository.mongo;

import com.fsd.bookingService.document.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailsRepository extends MongoRepository<BookingDetails,String> {
//    @Query("{bookingId:'?0'}")
    BookingDetails findByBookingId(String bookingId);

    List<BookingDetails> findByCustomerId(String customerId);

    List<BookingDetails> findByVendorId(String vendorId);
}