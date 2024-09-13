package com.fsd.template.serviceImpl;

import com.fsd.template.bean.ErrorBean;
import com.fsd.template.client.TemplateClient;
import com.fsd.template.dao.TemplateDao;
import com.fsd.template.entity.TemplateEntity;
import com.fsd.template.exception.TemplateException;
import com.fsd.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateDao dao;

    @Autowired
    TemplateClient client;

    @Override
    public List<TemplateEntity> dummyGetService() {
        if(dao.getdata().size()!=0)
        return dao.getdata();
        else{
            throw new TemplateException(new ErrorBean("OO1","data Not found"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
