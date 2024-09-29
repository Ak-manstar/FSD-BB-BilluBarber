//package com.fsd.bookingService.bean;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//public class VendorServiceMappingBean {
//
//
//    private Long id;
//
//    @JsonBackReference
//    @JoinColumn(name="service_id")
//    @ManyToOne
//    private ServiceEntity serviceEntity;
//
//    @JsonBackReference
//    @JoinColumn(name="vendor_id")
//    @ManyToOne
//    private VendorEntity vendorEntity;
//
//    private Long price;
//
//    @Column(name = "no_of_seats")
//    private Long noOfSeats;
//
//    @Column(name="created_at")
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "last_updated_at")
//    private LocalDateTime lastUpdatedAt;
//
//    @Column(name = "is_active")
//    private int isActive;
//}