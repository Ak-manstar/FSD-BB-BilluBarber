package com.fsd.bookingService.dao;

import com.fsd.bookingService.document.AvailableSlots;
import org.springframework.stereotype.Component;

@Component
public interface AvailableSlotsDao {

    AvailableSlots getAvailableSlots(String vendorId, String date);
    String updateAvailableSlots(AvailableSlots availableSlots);
}