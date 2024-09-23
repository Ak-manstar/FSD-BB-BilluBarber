package com.fsd.bookingService.dao;

import com.fsd.bookingService.entity.BookingsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingsDao {

    //methods to declare crud operations

    List<BookingsEntity> getdata();
}