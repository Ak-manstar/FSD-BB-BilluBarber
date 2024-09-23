package com.fsd.bookingService.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class BookingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "booking_id")
    private String bookingId;
    @Column(name = "vendor_key")
    private Long vendorKey;
    @Column(name = "customer_key")
    private Long customerKey;
    private String services;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt;

    @Column(name = "is_active")
    private int isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Long getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(Long vendorKey) {
        this.vendorKey = vendorKey;
    }

    public Long getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(Long customerKey) {
        this.customerKey = customerKey;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "BookingsEntity{" +
                "id=" + id +
                ", bookingId='" + bookingId + '\'' +
                ", vendorKey=" + vendorKey +
                ", customerKey=" + customerKey +
                ", services='" + services + '\'' +
                ", createdAt=" + createdAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", isActive=" + isActive +
                '}';
    }
}