package com.fsd.bookingService.controller;

import com.fsd.bookingService.bean.CreateBookingRequestBean;
import com.fsd.bookingService.bean.ResponseBean;
import com.fsd.bookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public ResponseEntity<ResponseBean> createBooking(@RequestBody CreateBookingRequestBean createBookingRequestBean, @PathVariable("vendorId") String vendorId,
                                                      @RequestParam String customerId){
        return new ResponseEntity<>(new ResponseBean(bookingService.createBooking(vendorId,createBookingRequestBean,customerId)), HttpStatus.OK);
    }

    @GetMapping("/bookingDetails/{bookingId}")
    public ResponseEntity<ResponseBean> getBookingDetails(@PathVariable("bookingId") String bookingId){
        return new ResponseEntity<>(new ResponseBean(bookingService.getBookingDetails(bookingId)), HttpStatus.OK);
    }

    @GetMapping("/customer/history/{customerId}")
    public ResponseEntity<ResponseBean> getCustomerBookingHistory(@PathVariable("customerId") String customerId){
        return new ResponseEntity<>(new ResponseBean(bookingService.getCustomerBookingHistory(customerId)), HttpStatus.OK);
    }

    @GetMapping("/vendor/history/{vendorId}")
    public ResponseEntity<ResponseBean> getVendorBookingHistory(@PathVariable("vendorId") String vendorId){
        return new ResponseEntity<>(new ResponseBean(bookingService.getVendorBookingHistory(vendorId)), HttpStatus.OK);
    }

    @GetMapping("/vendor/history/{vendorId}/{date}")
    public ResponseEntity<ResponseBean> getVendorBookingHistoryOnDate(@PathVariable("vendorId") String vendorId,@PathVariable("date") String date){
        return new ResponseEntity<>(new ResponseBean(bookingService.getVendorBookingHistoryOnDate(vendorId,date)), HttpStatus.OK);
    }

    @PutMapping("/remove/service/{bookingId}")
    public ResponseEntity<ResponseBean> updateBooking(@PathVariable("bookingId") String bookingId, @RequestParam String vendorId,@RequestParam Long vendorServiceKey){
        return new ResponseEntity<>(new ResponseBean(bookingService.removeServiceFormExistingBooking(bookingId,vendorId,vendorServiceKey)), HttpStatus.OK);
    }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<ResponseBean> cancelBooking(@PathVariable("bookingId") String bookingId){
        return new ResponseEntity<>(new ResponseBean(bookingService.cancelBooking(bookingId)), HttpStatus.OK);
    }





//    updateBookingDetails
//    updateBookingStatus

}