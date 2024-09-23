package com.fsd.bookingService.repository.mongo;

import com.fsd.bookingService.document.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingDetailsRepository extends MongoRepository<BookingDetails,String> {
}