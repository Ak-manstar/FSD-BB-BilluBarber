package com.fsd.template.controller;

import com.fsd.template.bean.ResponseBean;
import com.fsd.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class TemplateController {

    @Autowired
    TemplateService service;

    @GetMapping
    public ResponseEntity<ResponseBean> dummyGetController(){
        return new ResponseEntity<>(new ResponseBean(service.dummyGetService()), HttpStatus.OK);
    }
}
