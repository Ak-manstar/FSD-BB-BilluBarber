package com.fsd.bookingService.serviceImpl;

//import com.fasterxml.jackson.databind.util.JSONPObject;
//import com.fsd.bookingService.bean.CreateBookingRequestBean;
import com.fsd.bookingService.bean.*;
import com.fsd.bookingService.client.VendorClient;
import com.fsd.bookingService.dao.AvailableSlotsDao;
//import com.fsd.bookingService.dao.BookingDetailsDao;
import com.fsd.bookingService.dao.BookingsDao;
//import com.fsd.bookingService.document.AvailableSlots;
//import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.entity.AvailableSlotsEntity;
import com.fsd.bookingService.service.BookingService;
//import org.bson.json.JsonObject;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingsDao bookingsDao;

    @Autowired
    AvailableSlotsDao availableSlotsDao;

//    @Autowired
//    BookingDetailsDao bookingDetailsDao;

    @Autowired
    VendorClient vendorClient;

    @Autowired
    Gson gson;


    @Override
    public AvailableSlotsResponseBean getAvailableSlots(String vendorId, LocalDate date) {
        AvailableSlotsResponseBean availableSlotsResponseBean=new AvailableSlotsResponseBean();
     //   AvailableSlotsEntity availableSlots=availableSlotsDao.getAvailableSlots(vendorId,date);
        AvailableSlots availableSlots=availableSlotsDao.getAvailableSlots(vendorId,date);
        if(null!=availableSlots){
            availableSlotsResponseBean.setSlots(availableSlots.getSlots());
        }
        else {
            Object obj = vendorClient.fetchVendor(vendorId).getBody().getPayload();
            String jsonInString = new Gson().toJson(obj);
            JSONObject mJSONObject = new JSONObject(jsonInString);
            LocalTime open_time = LocalTime.parse(mJSONObject.get("openingTime").toString());
            LocalTime close_time = LocalTime.parse(mJSONObject.get("closingTime").toString());
            int no_of_slot = close_time.getHour()-open_time.getHour();
            int man_power=Integer.valueOf(mJSONObject.get("noOfStaff").toString());
            List<Slot> slots = new ArrayList<>();
            for (int i = 0; i < no_of_slot*2; i++) {
                Slot sl = new Slot();
                sl.setManpowerLeft(man_power);
                sl.setTime(open_time);
                slots.add(sl);
                open_time = open_time.plusMinutes(30);
            }

            availableSlotsResponseBean.setSlots(slots);

        }
        availableSlotsResponseBean.setDate(date);
        availableSlotsResponseBean.setVendorId(vendorId);
        return availableSlotsResponseBean;
    }

    @Override
    public BookingDetailsResponseBean createBooking(String vendorId, LocalDate date,LocalTime time,List<String> services) {
        AvailableSlotsResponseBean availableSlotsResponseBean=getAvailableSlots(vendorId,date);
        List<Slot> availableSlots=availableSlotsResponseBean.getSlots();
        List<BookedSlotResponseBean> slots=new ArrayList<>();
        LocalTime firstSlotTime=time;
        int c=services.size();
        AtomicInteger temp= new AtomicInteger(c);
        for(int i=0;i<availableSlots.size();i++){
            if(availableSlots.get(i).getTime().compareTo(firstSlotTime)==0 && temp.get() >0){
                availableSlots.get(i).setManpowerLeft(availableSlots.get(i).getManpowerLeft()-1);
                BookedSlotResponseBean bookedSlotResponseBean = new BookedSlotResponseBean();
                bookedSlotResponseBean.setServiceName(services.get(c- temp.get()));
                bookedSlotResponseBean.setTime(firstSlotTime.toString());
                slots.add(bookedSlotResponseBean);
                firstSlotTime=firstSlotTime.plusMinutes(30);
                temp.getAndDecrement();
            }
        }

        AvailableSlotsEntity availableSlotsEntity=new AvailableSlotsEntity();
        availableSlotsEntity.setVendorId(vendorId);
        availableSlotsEntity.setDate(date);
        availableSlotsEntity.setSlots(availableSlots.toString());
    //    String message=availableSlotsDao.updateAvailableSlots(availableSlotsEntity);



//        availableSlots=availableSlots.stream().map(x->{
//            if(x.getTime().compareTo(time)==1 && temp.get() >0){
//                x.setManpowerLeft(x.getManpowerLeft()-1);
//                    BookedSlotResponseBean bookedSlotResponseBean = new BookedSlotResponseBean();
//                    bookedSlotResponseBean.setServiceName(services.get(c- temp.get()));
//                    bookedSlotResponseBean.setTime(firstSlotTime.toString());
//                    slots.add(bookedSlotResponseBean);
//
//                    temp.getAndDecrement();
//            }
//            firstSlotTime=firstSlotTime.plusMinutes(30);
//            return x;
//        }).collect(Collectors.toList());

        BookingDetailsResponseBean bookingDetailsResponseBean=new BookingDetailsResponseBean();
        bookingDetailsResponseBean.setVendorName(vendorId);
        bookingDetailsResponseBean.setSlots(slots);
     //   bookingDetailsResponseBean.setMessage(slots.size()+" booked "+ message);

        return bookingDetailsResponseBean;
    }

//    @Override
//    public BookingDetails createBooking(CreateBookingRequestBean createBookingRequestBean) {
//        return null;
//    }
}