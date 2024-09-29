package com.fsd.bookingService.client;

import com.fsd.bookingService.bean.ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8081/vendor",name="vendor-client")
public interface VendorClient {

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBean> fetchVendor(@PathVariable("id") String vendorid);
}