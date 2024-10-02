package com.fsd.bookingService.repository.mongo;

import com.fsd.bookingService.document.AvailableSlots;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AvailableSlotsMongoRepository extends MongoRepository<AvailableSlots,String> {

//    @Query("{ $and:[{vendorId:'?0'}, {date:'?1'}] }")
    AvailableSlots findByVendorIdAndDate(String vendorId, String date);


}