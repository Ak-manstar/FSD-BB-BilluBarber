package com.fsd.bookingService.daoImpl;

import com.fsd.bookingService.dao.AvailableSlotsDao;
//import com.fsd.bookingService.document.AvailableSlots;
//import com.fsd.bookingService.repository.mongo.AvailableSlotsMongoRepository;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.repository.mongo.AvailableSlotsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AvailableSlotsDaoImpl implements AvailableSlotsDao {


    @Autowired
    AvailableSlotsMongoRepository availableSlotsRepository;

    @Override
    public AvailableSlots getAvailableSlots(String vendorId, String date) {
        return availableSlotsRepository.findByVendorIdAndDate(vendorId,date);
    }

    @Override
    public String updateAvailableSlots(AvailableSlots availableSlots) {
        AvailableSlots availableSlots1=getAvailableSlots(availableSlots.getVendorId(),availableSlots.getDate().toString());
        if(null!=availableSlots1){
            availableSlots1.setSlots(availableSlots.getSlots());
            availableSlotsRepository.save(availableSlots);
            return "updated";
        }else{
            availableSlotsRepository.save(availableSlots);
            return "saved";
        }

    }


//    @Autowired
//    AvailableSlotsMongoRepository availableSlotsRepository;
//
//
//    @Override
//    public AvailableSlotsEntity getAvailableSlots(String vendorId, LocalDate date) {
//        AvailableSlotsEntity availableSlots=availableSlotsRepository.findByVendorIdAndDate(vendorId,date);
//        return availableSlots;
//    }
//
//    @Override
//    public String updateAvailableSlots(AvailableSlotsEntity availableSlotsEntity) {
//        AvailableSlotsEntity availableSlots=getAvailableSlots(availableSlotsEntity.getVendorId(),availableSlotsEntity.getDate());
//        if(null!=availableSlots){
//            availableSlots.setSlots(availableSlotsEntity.getSlots());
//            availableSlotsRepository.save(availableSlots);
//            return "updated";
//        }else{
//            availableSlotsRepository.save(availableSlotsEntity);
//            return "added";
//        }
//    }
}