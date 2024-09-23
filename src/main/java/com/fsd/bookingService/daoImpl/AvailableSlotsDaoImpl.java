package com.fsd.bookingService.daoImpl;

import com.fsd.bookingService.dao.AvailableSlotsDao;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.repository.mongo.AvailableSlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class AvailableSlotsDaoImpl implements AvailableSlotsDao {

    @Autowired
    AvailableSlotsRepository availableSlotsRepository;


    @Override
    public AvailableSlots getAvailableSlots(Long vendorkey, LocalDate date) {
        AvailableSlots availableSlots=availableSlotsRepository.findSlotsByVendorkeyAndDate(vendorkey,date);
        return availableSlots;
    }
}