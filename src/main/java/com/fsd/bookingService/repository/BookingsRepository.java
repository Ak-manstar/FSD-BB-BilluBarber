package com.fsd.bookingService.repository;

import com.fsd.bookingService.entity.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<BookingsEntity,Long> {
}