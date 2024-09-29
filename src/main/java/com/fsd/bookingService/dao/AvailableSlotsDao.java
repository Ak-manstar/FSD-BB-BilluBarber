package com.fsd.bookingService.dao;

//import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.entity.AvailableSlotsEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public interface AvailableSlotsDao {

//    AvailableSlotsEntity getAvailableSlots(String vendorId, LocalDate date);
//    String updateAvailableSlots(AvailableSlotsEntity availableSlotsEntity);

    AvailableSlots getAvailableSlots(String vendorId, LocalDate date);
}