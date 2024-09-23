package com.fsd.bookingService.repository.mongo;

import com.fsd.bookingService.document.AvailableSlots;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AvailableSlotsRepository extends MongoRepository<AvailableSlots,String> {


    @Query("{ $and:[{vendorKey:'?0'}, {date:'?1'}] }")
    AvailableSlots findSlotsByVendorkeyAndDate(Long vendorkey, LocalDate date);
}