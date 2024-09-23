package com.fsd.bookingService.bean;

import java.util.List;

public class CreateBookingRequestBean {

    private Long customerKey;
    private Long vendorKey;
    private List<ServiceMapping> services;
}