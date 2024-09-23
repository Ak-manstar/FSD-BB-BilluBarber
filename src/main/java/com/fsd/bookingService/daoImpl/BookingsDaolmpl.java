package com.fsd.bookingService.daoImpl;

import com.fsd.bookingService.dao.BookingsDao;
import com.fsd.bookingService.entity.BookingsEntity;
import com.fsd.bookingService.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingsDaolmpl implements BookingsDao {

    @Autowired
    BookingsRepository repository;

    @Override
    public List<BookingsEntity> getdata() {
        return repository.findAll();
    }

    //methods to implement crud operations.
}