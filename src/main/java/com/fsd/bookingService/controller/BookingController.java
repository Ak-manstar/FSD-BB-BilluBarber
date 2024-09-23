package com.fsd.bookingService.controller;

import com.fsd.bookingService.bean.ResponseBean;
import com.fsd.bookingService.service.BookingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/{vendorKey}")
    public ResponseEntity<ResponseBean> getAvailableSlots(@PathVariable("vendorKey") Long vendorKey,
    @RequestParam String date){
        return new ResponseEntity<>(new ResponseBean(bookingService.getAvailableSlots(vendorKey,date)), HttpStatus.OK);
    }

//    getAvailableSlots
//    createBooking
//    getBookingDetails
//    updateBookingDetails
//    cancelbooking
//    updateBookingStatus

}