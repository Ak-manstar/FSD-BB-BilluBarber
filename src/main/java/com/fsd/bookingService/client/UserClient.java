package com.fsd.bookingService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8080/user",name="user-client")
public interface UserClient {

    @GetMapping("/{userId}")
    public ResponseEntity<String> getUserDetails(@PathVariable String userId);
}