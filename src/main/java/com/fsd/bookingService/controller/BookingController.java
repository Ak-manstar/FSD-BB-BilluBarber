package com.fsd.bookingService.controller;

import com.fsd.bookingService.bean.CreateBookingRequestBean;
import com.fsd.bookingService.bean.ResponseBean;
import com.fsd.bookingService.service.BookingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/{vendorId}")
    public ResponseEntity<ResponseBean> getAvailableSlots(@PathVariable("vendorId") String vendorId,
    @RequestParam LocalDate date){
        return new ResponseEntity<>(new ResponseBean(bookingService.getAvailableSlots(vendorId,date)), HttpStatus.OK);
    }

    @PostMapping("/{vendorId}")
    public ResponseEntity<ResponseBean> createBooking(@RequestBody List<String> services,@PathVariable("vendorId") String vendorId,
                                                      @RequestParam LocalDate date, @RequestParam LocalTime time){
//        , @RequestBody CreateBookingRequestBean createBookingRequestBean
      //  CreateBookingRequestBean createBookingRequestBean=new CreateBookingRequestBean();
        return new ResponseEntity<>(new ResponseBean(bookingService.createBooking(vendorId,date,time,services)), HttpStatus.OK);
    }
//    createBooking
//    getBookingDetails
//    updateBookingDetails
//    cancelbooking
//    updateBookingStatus

}