package com.fsd.bookingService.serviceImpl;

import com.fsd.bookingService.bean.*;
import com.fsd.bookingService.client.UserClient;
import com.fsd.bookingService.client.VendorClient;
import com.fsd.bookingService.dao.AvailableSlotsDao;
import com.fsd.bookingService.dao.BookingDetailsDao;
import com.fsd.bookingService.document.AvailableSlots;
import com.fsd.bookingService.document.BookingDetails;
import com.fsd.bookingService.helper.BookingHashUtils;
import com.fsd.bookingService.helper.BookingStatus;
import com.fsd.bookingService.helper.MapperUtil;
import com.fsd.bookingService.service.BookingService;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    UserClient userClient;

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
            FetchVendorResponseBean vendorResponseBean = fetchVedorDetailsByVendorId(vendorId);
            LocalTime open_time = LocalTime.parse(vendorResponseBean.getOpeningTime());
            LocalTime close_time = LocalTime.parse(vendorResponseBean.getClosingTime());
            int no_of_slot = close_time.getHour()-open_time.getHour();
            int man_power=vendorResponseBean.getNoOfStaff();
            List<Slot> slots = new ArrayList<>();
            for (int i = 0; i < no_of_slot*2; i++) {
                Slot sl = new Slot();
                sl.setManpowerLeft(man_power);
                sl.setTime(open_time.toString());
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
    @Transactional
    public BookingDetails createBooking(String vendorId, CreateBookingRequestBean createBookingRequestBean, String customerId) {
        String bookingId="BO"+BookingHashUtils.getId();
        BookingDetails bookingDetails = createOrUpdateBooking(vendorId, createBookingRequestBean.getDate(), createBookingRequestBean.getServices(), customerId, bookingId);
        return bookingDetails;
    }

    @Override
    public BookingDetails getBookingDetails(String bookingId) {
        return bookingDetailsDao.getBookingDetailsByBookingId(bookingId);
    }

    @Override
    public CustomerBookingHistoryResponseBean getCustomerBookingHistory(String customerId) {
        UserBean customer=getUser(customerId);
        List<BookingDetails> bookingHistory=bookingDetailsDao.getBookingHistoryByCustomerId(customerId);
        CustomerBookingHistoryResponseBean customerBookingHistoryResponseBean=new CustomerBookingHistoryResponseBean();
        customerBookingHistoryResponseBean.setCustomerName(customer.getUserName());
        customerBookingHistoryResponseBean.setCustomerId(customerId);
        customerBookingHistoryResponseBean.setCustomerPhone(customer.getMobile());
        List<CustomerVendorBookingDetails> bookingDetails=bookingHistory.parallelStream().map(x->{
            CustomerVendorBookingDetails customerVendorBookingDetails=new CustomerVendorBookingDetails();
            UserBean vendorDetails= getUser(x.getVendorId());
            customerVendorBookingDetails.setVendorName(vendorDetails.getUserName());
            customerVendorBookingDetails.setVendorId(vendorDetails.getUserId());
            customerVendorBookingDetails.setBookingId(x.getBookingId());
            customerVendorBookingDetails.setVendorPhone(vendorDetails.getMobile());
            customerVendorBookingDetails.setServices(x.getSlots());
            customerVendorBookingDetails.setDate(x.getDate());
            return customerVendorBookingDetails;
        }).collect(Collectors.toList());
        customerBookingHistoryResponseBean.setServiceHistory(bookingDetails);
        return customerBookingHistoryResponseBean;
    }

    @Override
    public VendorBookingHistoryResponseBean getVendorBookingHistory(String vendorId) {
        UserBean vendor=getUser(vendorId);
        List<BookingDetails> bookingHistory=bookingDetailsDao.getBookingHistoryByVendorId(vendorId);
        VendorBookingHistoryResponseBean vendorBookingHistoryResponseBean=new VendorBookingHistoryResponseBean();
        vendorBookingHistoryResponseBean.setVendorName(vendor.getUserName());
        vendorBookingHistoryResponseBean.setVendorPhone(vendor.getMobile());
        List<CustomerBokingDetails> bookingDetails = getCustomerBokingDetails(bookingHistory);
        vendorBookingHistoryResponseBean.setServiceHistory(bookingDetails);
        return vendorBookingHistoryResponseBean;
    }

    private List<CustomerBokingDetails> getCustomerBokingDetails(List<BookingDetails> bookingHistory) {
        List<CustomerBokingDetails> bookingDetails= bookingHistory.parallelStream().map(x->{
            CustomerBokingDetails customerBokingDetails=new CustomerBokingDetails();
            UserBean customerDetails= getUser(x.getCustomerId());
            customerBokingDetails.setCustomerName(customerDetails.getUserName());
            customerBokingDetails.setCustomerPhone(customerDetails.getMobile());
            customerBokingDetails.setBookingId(x.getBookingId());
            customerBokingDetails.setServices(x.getSlots());
            customerBokingDetails.setDate(x.getDate());
            return customerBokingDetails;
        }).collect(Collectors.toList());
        return bookingDetails;
    }

    @Override
    @Transactional
    public BookingDetails removeServiceFormExistingBooking(String bookingId, String vendorId, Long vendorServiceKey) {
        BookingDetails bookingDetails=bookingDetailsDao.getBookingDetailsByBookingId(bookingId);
        AvailableSlotsResponseBean availableSlotsResponseBean=getAvailableSlots(vendorId,LocalDate.parse(bookingDetails.getDate()));
        List<BookedSlotResponseBean> slots=bookingDetails.getSlots();
        Optional<BookedSlotResponseBean> slot=bookingDetails.getSlots().stream().filter(x->x.getVendorServiceKey() ==vendorServiceKey).findFirst();
        if(slot.isPresent()){
            slots.remove(slot.get());
            if(slots.size()==0)
                bookingDetails.setStatus(BookingStatus.CANCLED);
            bookingDetails.setSlots(slots);
            availableSlotsResponseBean.setSlots(availableSlotsResponseBean.getSlots().stream().map(x->{
                if(x.getTime().equals(slot.get().getTime())){
                    x.setManpowerLeft(x.getManpowerLeft()+1);
                }
                return x;
            }).collect(Collectors.toList()));
        }
        String message =bookingDetailsDao.saveBookingDetails(bookingDetails);

        AvailableSlots availableSlotsDoc = MapperUtil.mapAvailableSlots(vendorId, bookingDetails.getDate().toString(), availableSlotsResponseBean.getSlots());
        String message2=availableSlotsDao.updateAvailableSlots(availableSlotsDoc);

        return bookingDetails;
    }

    @Override
    public VendorBookingHistoryResponseBean getVendorBookingHistoryOnDate(String vendorId, String date) {
        UserBean vendor=getUser(vendorId);
        List<BookingDetails> bookingHistory=bookingDetailsDao.getBookingHistoryByVendorIdAndDate(vendorId,date);
        VendorBookingHistoryResponseBean vendorBookingHistoryResponseBean=new VendorBookingHistoryResponseBean();
        vendorBookingHistoryResponseBean.setVendorName(vendor.getUserName());
        vendorBookingHistoryResponseBean.setVendorPhone(vendor.getMobile());
        List<CustomerBokingDetails> bookingDetails = getCustomerBokingDetails(bookingHistory);
        vendorBookingHistoryResponseBean.setServiceHistory(bookingDetails);
        return vendorBookingHistoryResponseBean;
    }

    @Override
    public BookingDetails cancelBooking(String bookingId) {
        BookingDetails bookingDetails= bookingDetailsDao.getBookingDetailsByBookingId(bookingId);
        bookingDetails.setStatus(BookingStatus.CANCLED);
        AvailableSlotsResponseBean availableSlotsResponseBean=getAvailableSlots(bookingDetails.getVendorId(),LocalDate.parse(bookingDetails.getDate()));
        bookingDetails.getSlots().stream().forEach(y->{
            availableSlotsResponseBean.setSlots(availableSlotsResponseBean.getSlots().stream().map(x->{
                if(x.getTime().equals(y.getTime())){
                    x.setManpowerLeft(x.getManpowerLeft()+1);
                }
                return x;
            }).collect(Collectors.toList()));
        });
        bookingDetailsDao.saveBookingDetails(bookingDetails);
        AvailableSlots availableSlotsDoc = MapperUtil.mapAvailableSlots(bookingDetails.getVendorId(), bookingDetails.getDate().toString(), availableSlotsResponseBean.getSlots());
        String message2=availableSlotsDao.updateAvailableSlots(availableSlotsDoc);
        return bookingDetails;
    }

    private UserBean getUser(String customerId) {
        String json =new JSONObject(userClient.getUserDetails(customerId).getBody()).getJSONObject("payload").toString();
        UserBean userBean=gson.fromJson(json, UserBean.class);
        return userBean;
    }

    private FetchVendorResponseBean fetchVedorDetailsByVendorId(String vendorId) {
       String json=new JSONObject(vendorClient.fetchVendor(vendorId).getBody()).getJSONObject("payload").toString();
       FetchVendorResponseBean vendorResponseBean = gson.fromJson(json,FetchVendorResponseBean.class);
        return vendorResponseBean;
    }

    private BookingDetails createOrUpdateBooking(String vendorId, LocalDate date, List<SlotBookingRequestBean> services, String customerId, String bookingId) {
        AvailableSlotsResponseBean availableSlotsResponseBean=getAvailableSlots(vendorId, date);
        FetchVendorResponseBean vendorResponseBean  = fetchVedorDetailsByVendorId(vendorId);
        List<Slot> availableSlots=availableSlotsResponseBean.getSlots();
        List<BookedSlotResponseBean> slots=new ArrayList<>();
        int c= services.size();
        int temp= 0;
        for(int i=0;i<availableSlots.size();i++){
            if(temp< services.size()&&LocalTime.parse(availableSlots.get(i).getTime()).compareTo(services.get(temp).getTime())==0){
                availableSlots.get(i).setManpowerLeft(availableSlots.get(i).getManpowerLeft()-1);
                BookedSlotResponseBean bookedSlotResponseBean = new BookedSlotResponseBean();
                int finalTemp = temp;
                VerdorServiceResponseBean verdorServiceResponseBean=vendorResponseBean.getServices().stream().filter(x->
                        (x.getVendorServicekey() == services.get(finalTemp).getServiceKey())).findFirst().orElse(null);
                bookedSlotResponseBean.setVendorServiceKey(services.get(finalTemp).getServiceKey());
                bookedSlotResponseBean.setTime(services.get(finalTemp).getTime().toString());
                bookedSlotResponseBean.setServiceName(verdorServiceResponseBean.getServiceName());
                bookedSlotResponseBean.setPrice(verdorServiceResponseBean.getPrice());
                slots.add(bookedSlotResponseBean);
                temp++;
            }
        }
        AvailableSlots availableSlotsDoc = MapperUtil.mapAvailableSlots(vendorId, date.toString(), availableSlots);
        String message=availableSlotsDao.updateAvailableSlots(availableSlotsDoc);

        BookingDetails bookingDetails = MapperUtil.mapBookingDetails(vendorId, date, customerId, bookingId, slots);
        bookingDetailsDao.saveBookingDetails(bookingDetails);
        return bookingDetails;
    }


}