//package com.fsd.bookingService.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fsd.bookingService.bean.Slot;
//import jakarta.persistence.*;
////import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Table(name = "available_solts")
//public class AvailableSlotsEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
//    private Long id;
//    @Column(name="vendor_id")
//    private String vendorId;
//    private LocalDate date;
//    private String slots;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getVendorId() {
//        return vendorId;
//    }
//
//    public void setVendorId(String vendorId) {
//        this.vendorId = vendorId;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public String getSlots() {
//        return slots;
//    }
//
//    public void setSlots(String slots) {
//        this.slots = slots;
//    }
//
//    @Override
//    public String toString() {
//        return "AvailableSlotsEntity{" +
//                "id='" + id + '\'' +
//                ", vendorId=" + vendorId +
//                ", date=" + date +
//                ", slots=" + slots +
//                '}';
//    }
//}