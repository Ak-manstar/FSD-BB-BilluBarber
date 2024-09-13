package com.fsd.template.service;

import com.fsd.template.entity.TemplateEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TemplateService {

    //here you can declare methods of service

    List<TemplateEntity> dummyGetService();
}
