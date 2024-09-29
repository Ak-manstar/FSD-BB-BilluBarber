package com.fsd.bookingService.serviceImpl;

import com.fsd.bookingService.bean.AvailableSlotsResponseBean;
import com.fsd.bookingService.bean.BookedSlotResponseBean;
import com.fsd.bookingService.bean.Slot;
import com.fsd.bookingService.client.VendorClient;
import com.fsd.bookingService.dao.AvailableSlotsDao;
import com.fsd.bookingService.dao.BookingDetailsDao;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.helper.BookingHashUtils;
import com.fsd.bookingService.service.BookingService;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class BookingServiceImpl implements BookingService {

//    @Autowired
//    BookingsDao bookingsDao;

    @Autowired
    AvailableSlotsDao availableSlotsDao;

    @Autowired
    BookingDetailsDao bookingDetailsDao;

    @Autowired
    VendorClient vendorClient;

    @Autowired
    Gson gson;


    @Override
    public AvailableSlotsResponseBean getAvailableSlots(String vendorId, LocalDate date) {
        AvailableSlotsResponseBean availableSlotsResponseBean=new AvailableSlotsResponseBean();
        AvailableSlots availableSlots=availableSlotsDao.getAvailableSlots(vendorId,date.toString());
        if(null!=availableSlots){
            availableSlotsResponseBean.setSlots(availableSlots.getSlots());
        }
        else {
            Object respObj = vendorClient.fetchVendor(vendorId).getBody().getPayload();
            String jsonInString = gson.toJson(respObj);
            JSONObject respJsonObject = new JSONObject(jsonInString);
            LocalTime open_time = LocalTime.parse(respJsonObject.get("openingTime").toString());
            LocalTime close_time = LocalTime.parse(respJsonObject.get("closingTime").toString());
            int no_of_slot = close_time.getHour()-open_time.getHour();
            int man_power=Integer.valueOf(respJsonObject.get("noOfStaff").toString());
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
    public BookingDetails createBooking(String vendorId, LocalDate date,LocalTime time,List<String> services) {
        String bookingId="BO"+BookingHashUtils.getId();
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
        AvailableSlots availableSlotsDoc=new AvailableSlots();
        availableSlotsDoc.setVendorId(vendorId);
        availableSlotsDoc.setDate(date.toString());
        availableSlotsDoc.setSlots(availableSlots);
        String message=availableSlotsDao.updateAvailableSlots(availableSlotsDoc);

        BookingDetails bookingDetails=new BookingDetails();
        bookingDetails.setBookingId(bookingId);
        bookingDetails.setDate(date.toString());
        bookingDetails.setVendorId(vendorId);
        bookingDetails.setSlots(slots);
        bookingDetailsDao.saveBookingDetails(bookingDetails);




//        BookingDetailsResponseBean bookingDetailsResponseBean=new BookingDetailsResponseBean();
//        bookingDetailsResponseBean.setVendorName(vendorId);
//        bookingDetailsResponseBean.setSlots(slots);
//        bookingDetailsResponseBean.setMessage(slots.size()+" booked "+ message);

        return bookingDetails;
    }


}