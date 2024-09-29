package com.fsd.bookingService.repository;

//import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.entity.AvailableSlotsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AvailableSlotsRepository extends JpaRepository<AvailableSlotsEntity,Long> {
    AvailableSlotsEntity findByVendorIdAndDate(String vendorId, LocalDate date);
//    int updateAvailableSlots(AvailableSlotsEntity availableSlotsEntity);
}