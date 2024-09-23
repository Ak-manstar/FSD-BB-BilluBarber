package com.fsd.bookingService.dao;

import com.fsd.bookingService.document.AvailableSlots;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public interface AvailableSlotsDao {

    AvailableSlots getAvailableSlots(Long vendorkey, LocalDate date);
}